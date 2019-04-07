NLP PROJECT: Calculates content word(Adj, Noun, Verb, Advb) count; Lexical diversity through MLTD index score; and  Content Diversity
Flesch Kincaid PROJECT: Calculates FK/Readability Score 
![](_results/results.csv)

To run Flesch Kincaid PROJECT: 
1. Download/Clone the project
2. Open in eclipse 
4. Change all path variables in "DriverClass.java" & "CleanData.java"
     (changing value of 'projectPath' should be sufficient)
4. Run CleanData, if required
5. Run DriverClass (make sure output file path exists)



Instructions to run the NLP Project:
To run this project first download Stanford CoreNLP from
https://stanfordnlp.github.io/CoreNLP/download.html

Start the NLP Server:
cd path/stanford-corenlp-full-2018-10-05
java -mx4g -cp "*" edu.stanford.nlp.pipeline.StanfordCoreNLPServer -annotators "tokenize,ssplit,pos,lemma,parse,sentiment" -port 9000 -timeout 30000

Python
Install Anaconda
https://www.anaconda.com/distribution/


Anaconda Prompt

Create a Virtual ENV for Python 3
conda create -n yourenvname python=x.x anaconda

Activate
source activate yourenvname
Ref: https://uoa-eresearch.github.io/eresearch-cookbook/recipe/2014/11/20/conda/

Install SNLP Library
pip install stanfordcorenlp

N.B. The path "os.walk( "C:/Users/souro/OneDrive/Desktop/workstation/Text Analytics/CleanTextFiles")" mentioned here is the absolute directory structure for the clean text files to be processed. You can put them in any folder structure inside this path.

*********************

Results of NLP:

```
runfile('C:/Users/souro/Projects/TA_FleschKincaidScore/NLP/NlpAnalyser.py', wdir='C:/Users/souro/Projects/TA_FleschKincaidScore/NLP')
C:/Users/souro/OneDrive/Desktop/workstation/Text Analytics/CleanTextFiles/Class A/Subject A/2.txt
MLTD = 55.90109533994426
Factors = 169.54945054945054, word count = 9478, noun count = 2421, verb count = 1392, adjective count = 805, adverb count = 292, foreign word count = 12, content diversity = 0.29063136456211813
Verb-Noun Ratio = 1.7915632754342432
 
C:/Users/souro/OneDrive/Desktop/workstation/Text Analytics/CleanTextFiles/Class A/Subject B/1.txt
MLTD = 63.73662001017274
Factors = 103.88062622309198, word count = 6621, noun count = 1691, verb count = 941, adjective count = 541, adverb count = 292, foreign word count = 7, content diversity = 0.3217893217893218
Verb-Noun Ratio = 1.9964285714285714
 
http://en.wikipedia.org/wiki/Flesch%E2%80%93Kincaid_readability_tests
```

Results Of FLesch Kinkaid Exp:
```
![](_results/results.csv)
C:\USERS\SWASTIK\DESKTOP\MASTERSDEGREE_CS\SEMESTER_2\TEXTANALYTICS\PROJECT\US TEXTBOOKS\10\10TH_FULL.TXT
FleschKincaid Implementation 1:
--------------------------------------------------------------
Stats:[words: 137258, sentences: 8015, text: 0, blank: 0, syllables: 233625, complex: 26197]
calcFog: 14.484439
calcKincaid: 11.173426
wordsPerSentence: 17.125141
percentComplexWords: 19.085957
syllablesPerWords: 1.7020866
Flesch Score: 45.456467


FleschKincaid Implementation 2:
----------------------------------
Flesch Score: 47.92764487521539

FleschKincaid Implementation 3(StanfordNLP_Lexer):
----------------------------------
Flesch Score: 53.96019238193372

***********************

C:\USERS\SWASTIK\DESKTOP\MASTERSDEGREE_CS\SEMESTER_2\TEXTANALYTICS\PROJECT\INDIANTEXTBOOKS\10\10TH_FULL.TXT
FleschKincaid Implementation 1:
--------------------------------------------------------------
Stats:[words: 111463, sentences: 6101, text: 0, blank: 0, syllables: 192184, complex: 22524]
calcFog: 15.390892
calcKincaid: 11.880661
wordsPerSentence: 18.269629
percentComplexWords: 20.207602
syllablesPerWords: 1.7241955
Flesch Score: 42.424408


FleschKincaid Implementation 2:
----------------------------------
Flesch Score: 43.499227290521006

FleschKincaid Implementation 3(StanfordNLP_Lexer):
----------------------------------
Flesch Score: 49.34652862764942

***********************

C:\USERS\SWASTIK\DESKTOP\MASTERSDEGREE_CS\SEMESTER_2\TEXTANALYTICS\PROJECT\US TEXTBOOKS\10\CIVICS\CLEAN\FULL.TXT
FleschKincaid Implementation 1:
--------------------------------------------------------------
Stats:[words: 29955, sentences: 1534, text: 0, blank: 0, syllables: 51845, complex: 6244]
calcFog: 16.148792
calcKincaid: 12.448681
wordsPerSentence: 19.52738
percentComplexWords: 20.844599
syllablesPerWords: 1.7307628
Flesch Score: 40.59218


FleschKincaid Implementation 2:
----------------------------------
Flesch Score: 40.67393698419058

FleschKincaid Implementation 3(StanfordNLP_Lexer):
----------------------------------
Flesch Score: 46.32944858413444

***********************

C:\USERS\SWASTIK\DESKTOP\MASTERSDEGREE_CS\SEMESTER_2\TEXTANALYTICS\PROJECT\US TEXTBOOKS\10\ECONOMICS\CLEAN\FULL.TXT
FleschKincaid Implementation 1:
--------------------------------------------------------------
Stats:[words: 31271, sentences: 1731, text: 0, blank: 0, syllables: 52613, complex: 5854]
calcFog: 14.7142
calcKincaid: 11.308786
wordsPerSentence: 18.06528
percentComplexWords: 18.72022
syllablesPerWords: 1.6824853
Flesch Score: 46.160492


FleschKincaid Implementation 2:
----------------------------------
Flesch Score: 46.38033469265342

FleschKincaid Implementation 3(StanfordNLP_Lexer):
----------------------------------
Flesch Score: 50.665430765669285

***********************

C:\USERS\SWASTIK\DESKTOP\MASTERSDEGREE_CS\SEMESTER_2\TEXTANALYTICS\PROJECT\US TEXTBOOKS\10\WORLD HISTORY\CLEAN\FULL.TXT
FleschKincaid Implementation 1:
--------------------------------------------------------------
Stats:[words: 50237, sentences: 2836, text: 0, blank: 0, syllables: 87726, complex: 10426]
calcFog: 15.387064
calcKincaid: 11.924137
wordsPerSentence: 17.714033
percentComplexWords: 20.753628
syllablesPerWords: 1.7462428
Flesch Score: 41.123123


FleschKincaid Implementation 2:
----------------------------------
Flesch Score: 43.27081832649341

FleschKincaid Implementation 3(StanfordNLP_Lexer):
----------------------------------
Flesch Score: 50.245411561573846

***********************

C:\USERS\SWASTIK\DESKTOP\MASTERSDEGREE_CS\SEMESTER_2\TEXTANALYTICS\PROJECT\INDIANTEXTBOOKS\10\CIVICS\CLEAN\FULL.TXT
FleschKincaid Implementation 1:
--------------------------------------------------------------
Stats:[words: 36103, sentences: 2258, text: 0, blank: 0, syllables: 62280, complex: 7385]
calcFog: 14.577716
calcKincaid: 11.001442
wordsPerSentence: 15.988928
percentComplexWords: 20.455364
syllablesPerWords: 1.7250644
Flesch Score: 44.665802


FleschKincaid Implementation 2:
----------------------------------
Flesch Score: 47.011660348410516

FleschKincaid Implementation 3(StanfordNLP_Lexer):
----------------------------------
Flesch Score: 51.33794058592589

***********************

C:\USERS\SWASTIK\DESKTOP\MASTERSDEGREE_CS\SEMESTER_2\TEXTANALYTICS\PROJECT\INDIANTEXTBOOKS\10\HISTORY\CLEAN\FULL.TXT
FleschKincaid Implementation 1:
--------------------------------------------------------------
Stats:[words: 66324, sentences: 3804, text: 0, blank: 0, syllables: 113595, complex: 12583]
calcFog: 14.56294
calcKincaid: 11.419975
wordsPerSentence: 17.435331
percentComplexWords: 18.972017
syllablesPerWords: 1.7127284
Flesch Score: 44.241333


FleschKincaid Implementation 2:
----------------------------------
Flesch Score: 45.847846045732716

FleschKincaid Implementation 3(StanfordNLP_Lexer):
----------------------------------
Flesch Score: 52.85156426012828

***********************

C:\USERS\SWASTIK\DESKTOP\MASTERSDEGREE_CS\SEMESTER_2\TEXTANALYTICS\PROJECT\INDIANTEXTBOOKS\10\ECONOMICS\CLEAN\FULL.TXT
FleschKincaid Implementation 1:
--------------------------------------------------------------
Stats:[words: 34831, sentences: 1953, text: 0, blank: 0, syllables: 57750, complex: 6229]
calcFog: 14.287244
calcKincaid: 10.929968
wordsPerSentence: 17.834614
percentComplexWords: 17.883495
syllablesPerWords: 1.6580058
Flesch Score: 48.46559


FleschKincaid Implementation 2:
----------------------------------
Flesch Score: 52.59889991492061

FleschKincaid Implementation 3(StanfordNLP_Lexer):
----------------------------------
Flesch Score: 58.56803755949679

***********************

C:\USERS\SWASTIK\DESKTOP\MASTERSDEGREE_CS\SEMESTER_2\TEXTANALYTICS\PROJECT\US TEXTBOOKS\6\GEOGRAPHY\CLEAN\FULL.TXT
FleschKincaid Implementation 1:
--------------------------------------------------------------
Stats:[words: 34127, sentences: 2105, text: 0, blank: 0, syllables: 54968, complex: 5428]
calcFog: 12.847058
calcKincaid: 9.738953
wordsPerSentence: 16.21235
percentComplexWords: 15.905295
syllablesPerWords: 1.6106895
Flesch Score: 54.115143


FleschKincaid Implementation 2:
----------------------------------
Flesch Score: 54.70419580161195

FleschKincaid Implementation 3(StanfordNLP_Lexer):
----------------------------------
Flesch Score: 59.01602051006759

***********************

C:\USERS\SWASTIK\DESKTOP\MASTERSDEGREE_CS\SEMESTER_2\TEXTANALYTICS\PROJECT\INDIANTEXTBOOKS\6\GEOGRAPHY\CLEAN\FULL.TXT
FleschKincaid Implementation 1:
--------------------------------------------------------------
Stats:[words: 14869, sentences: 949, text: 0, blank: 0, syllables: 22301, complex: 1848]
calcFog: 11.2386465
calcKincaid: 8.218565
wordsPerSentence: 15.668072
percentComplexWords: 12.428543
syllablesPerWords: 1.4998319
Flesch Score: 64.046135


FleschKincaid Implementation 2:
----------------------------------
Flesch Score: 69.23944981644134

FleschKincaid Implementation 3(StanfordNLP_Lexer):
----------------------------------
Flesch Score: 76.58229677419358

***********************

```

