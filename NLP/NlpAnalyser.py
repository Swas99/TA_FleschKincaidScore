# -*- coding: utf-8 -*-
"""
Spyder Editor

This is a temporary script file.
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
    annotatedText = json.loads(nlp.annotate(text, properties=props))#, #properties=props)
    return annotatedText


def processAnnotatedText(annotatedText, ttr=0.72):
    global sentences
    nouns = []
    #adjectives = []
    #verbs = []
    words = []
    token = []
    types = set()
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
            if 'NN' in token['pos']:
                nouns.append(token['word'])
        # Verbs Extraction
    # if '' in token['pos']:
    #    verbs.append(token['word'])
    # Adjectives Extraction
    # if '' in token['pos']:
    #    adjectives.append(token['word'])

    excess = 1.0 - currentTtr
    excessVal = 1.0 - ttr

    factors += excess / excessVal
   # return factors, words, nouns, verbs, adjectives
    return factors, words, nouns

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
for root, dirs, files in os.walk("C:/Users/souro/OneDrive/Desktop/workstation/Text Analytics/CleanTextFiles"):
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
    factors, words, nouns = processAnnotatedText(annotatedText)
    
    mltdIndex = calculateMltd(factors, len(words))
    print('MLTD = {}'.format(mltdIndex))
    print('Factors = {}, word count = {}, noun count = {}'.format(factors, len(words), len(nouns)))
    print(' ')