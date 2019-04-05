# -*- coding: utf-8 -*-
"""
NLP Analyser

"""
from stanfordcorenlp import StanfordCoreNLP
import os
import json
#import glob

filesList = []

nlp = None
props = None

sentences = 0


def init():
    global nlp
    global props
    nlp = StanfordCoreNLP('http://127.0.0.1', port=9000, timeout=100)
    props = {
        'annotators': 'ssplit,pos,lemma',
        'pipelineLanguage': 'en',
        'outputFormat': 'json'
    }


def annotateText(text):
    annotatedText = json.loads(nlp.annotate(text, properties=props))
    return annotatedText


def processAnnotatedText(annotatedText, ttr=0.72):
    global sentences
    nouns = []
    adjectives = []
    verbs = []
    adjectives = []
    adverbs = []
    foreignWords = []
    
    words = []
    token = []
    types = set()
    
    nounTypes = set()
    uniqueNounCount = 0
    verbTypes = set()
    uniqueVerbCount = 0
    adjectiveTypes = set()
    uniqueAdjectiveCount = 0
    adverbTypes = set()
    uniqueAdverbCount = 0
    
    
    
    currentTtr = 1.0
    tokenCount = 0
    typeCount = 0
    factors = 0.0

    for sentence in annotatedText['sentences']:
        sentences += 1
        for token in sentence['tokens']:
            tokenCount += 1
            if token['word'].lower() not in types:
                typeCount += 1
                types.add(token['word'].lower())
            currentTtr = typeCount / tokenCount
            if currentTtr <= ttr:
                factors += 1
                currentTtr = 1.0
                tokenCount = 0
                typeCount = 0
                types = set()

            # This is for Content Diversity
            words.append(token['word'].lower().strip())
            # Noun Extraction
            if token['pos'] in ['NN','NNS','NNP','NNPS']:
                nouns.append(token['word'])
            # Verbs Extraction
            if token['pos'] in ['VB','VBD','VBG','VBN','VBP','VBZ']:
                verbs.append(token['word'])
            # Adjective Extraction
            if token['pos'] in ['JJ','JJR','JJS']:
                adjectives.append(token['word'])
            # Adverb Extraction
            if token['pos'] in ['RB','RBR','RBS']:
                adverbs.append(token['word'])
            # Foreign Words Extraction
            if token['pos'] in ['FW']:
                foreignWords.append(token['word'])
    

    excess = 1.0 - currentTtr
    excessVal = 1.0 - ttr

    factors += excess / excessVal
    for noun in nouns:
        if noun not in nounTypes:
            uniqueNounCount += 1
            nounTypes.add(noun)
    for verb in verbs:
        if verb not in verbTypes:
            uniqueVerbCount += 1
            verbTypes.add(verb)
    for adverb in adverbs:
        if adverb not in adverbTypes:
            uniqueAdverbCount += 1
            adverbTypes.add(adverb)
    for adjective in adjectives:
        if adjective not in adjectiveTypes:
            uniqueAdjectiveCount += 1
            adjectiveTypes.add(adjective)
   # return factors, words, nouns, verbs, adjectives
    return factors, words, nouns, verbs, adjectives, adverbs, foreignWords,uniqueNounCount,uniqueVerbCount,uniqueAdverbCount,uniqueAdjectiveCount

def calculateMltd(factors, totalWordsCount):
    return totalWordsCount / factors


def readFileData(inputFile):
    text = ''
    with open(inputFile, 'r', encoding='utf-8') as filePointer:
        for line in filePointer:
            text += line + '\n'
    return text


def computeMetrics():
    init()

init()
for root, dirs, files in os.walk( "C:/Users/souro/OneDrive/Desktop/workstation/Text Analytics/CleanTextFiles"):
    for file in files:
        if file.endswith('.txt'):
            #print(os.path)
            st = str(os.path.join(root, file)).replace('\\','/')
            filesList.append(st)#os.path.join(root, file))

for file in filesList:
    print(file)
    #text
    text = readFileData(file)
    #print(text)
    annotatedText = annotateText(text)
    #factors, words, nouns, verbs, adjectives = processAnnotatedText(annotatedText)
    factors, words, nouns, verbs, adjectives, adverbs, foreignWords, uniqueNounCount, uniqueVerbCount, uniqueAdverbCount,uniqueAdjectiveCount = processAnnotatedText(annotatedText)
    
    mltdIndex = calculateMltd(factors, len(words))
    uniqueContentWords = uniqueNounCount+uniqueVerbCount+uniqueAdverbCount+uniqueAdjectiveCount
    print('MLTD = {}'.format(mltdIndex))
    print('Factors = {}, word count = {}, noun count = {}, verb count = {}, adjective count = {}, adverb count = {}, foreign word count = {}, content diversity = {}'.format(factors, len(words), len(nouns), len(verbs), len(adjectives),len(adverbs), len(foreignWords),(uniqueContentWords/(len(nouns)+len(verbs)+len(adjectives)+len(adverbs)))))
    print('Noun-Verb Ratio = {}'.format(uniqueNounCount/uniqueVerbCount))
    print(' ')
