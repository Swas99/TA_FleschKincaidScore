Readme --

Instructions to execute the code on the branch.

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
http://en.wikipedia.org/wiki/Flesch%E2%80%93Kincaid_readability_tests

Results

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
 
