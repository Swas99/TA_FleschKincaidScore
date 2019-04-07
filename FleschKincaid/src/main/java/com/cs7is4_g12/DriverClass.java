
package com.cs7is4_g12;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import com.cs7is4_g12.fleschkincaid_1.FleschKincaid;
import com.cs7is4_g12.fleschkincaid_1.lexer.sentence.StandfordNLPSentenceLexer;
import com.cs7is4_g12.fleschkincaid_2.Readability;
import com.cs7is4_g12.fleschkincaid_2.ReadabilityCalculator;
 

public class DriverClass {



	final static String projectPath = "C:\\Users\\Swastik\\Desktop\\MastersDegree_CS\\Semester_2\\TextAnalytics\\Project\\";

final static String paths_2[] = 
	{
		projectPath + "IndianTextBooks\\1\\" + "1_full.txt",
	    projectPath + "IndianTextBooks\\2\\" + "2_full.txt",
	    projectPath + "IndianTextBooks\\3\\" + "3_full.txt",
	    projectPath + "IndianTextBooks\\4\\" + "4_full.txt",
	    projectPath + "IndianTextBooks\\5\\" + "5_full.txt",
	    projectPath + "IndianTextBooks\\6\\" + "6_full.txt",
	    projectPath + "IndianTextBooks\\7\\" + "7_full.txt",
	    projectPath + "IndianTextBooks\\8\\" + "8_full.txt",
	    projectPath + "IndianTextBooks\\9\\" + "9_full.txt",
	    projectPath + "IndianTextBooks\\10\\" + "10_full.txt",
		projectPath + "US TextBooks\\1\\" + "1_full.txt",
		projectPath + "US TextBooks\\2\\" + "2_full.txt",
		projectPath + "US TextBooks\\3\\" + "3_full.txt",
		projectPath + "US TextBooks\\4\\" + "4_full.txt",
		projectPath + "US TextBooks\\5\\" + "5_full.txt",
		projectPath + "US TextBooks\\6\\" + "6_full.txt",
		projectPath + "US TextBooks\\7\\" + "7_full.txt",
		projectPath + "US TextBooks\\8\\" + "8_full.txt",
//		projectPath + "US TextBooks\\9\\" + "9_full.txt",
		projectPath + "US TextBooks\\10\\" + "10_full.txt",
	};



	final static String paths_1[] = 
		{
			projectPath + "IndianTextBooks\\1\\English\\" + "clean\\full.txt",
			projectPath + "IndianTextBooks\\2\\English\\"+ "clean\\full.txt",
			projectPath + "IndianTextBooks\\3\\English\\"+ "clean\\full.txt",
			projectPath + "IndianTextBooks\\3\\EVS\\"+ "clean\\full.txt",
			projectPath + "IndianTextBooks\\4\\English\\"+ "clean\\full.txt",
			projectPath + "IndianTextBooks\\4\\EVS\\"+ "clean\\full.txt",
			projectPath + "IndianTextBooks\\5\\English\\"+ "clean\\full.txt",
			projectPath + "IndianTextBooks\\5\\EVS\\"+ "clean\\full.txt",
			projectPath + "IndianTextBooks\\6\\English\\"+ "clean\\full.txt",
			projectPath + "IndianTextBooks\\6\\Civics\\"+ "clean\\full.txt",
			projectPath + "IndianTextBooks\\6\\Geography\\"+ "clean\\full.txt",
			projectPath + "IndianTextBooks\\6\\History\\"+ "clean\\full.txt",
			projectPath + "IndianTextBooks\\6\\Science\\"+ "clean\\full.txt",
			projectPath + "IndianTextBooks\\7\\English\\"+ "clean\\full.txt",
			projectPath + "IndianTextBooks\\7\\Civics\\"+ "clean\\full.txt",
			projectPath + "IndianTextBooks\\7\\Geography\\"+ "clean\\full.txt",
			projectPath + "IndianTextBooks\\7\\Science\\"+ "clean\\full.txt",
			projectPath + "IndianTextBooks\\8\\English\\"+ "clean\\full.txt",
			projectPath + "IndianTextBooks\\8\\Civics\\"+ "clean\\full.txt",
			projectPath + "IndianTextBooks\\8\\Geography\\"+ "clean\\full.txt",
			projectPath + "IndianTextBooks\\8\\Science\\"+ "clean\\full.txt",
			projectPath + "IndianTextBooks\\9\\English\\"+ "clean\\full.txt",
			projectPath + "IndianTextBooks\\9\\Civics\\"+ "clean\\full.txt",
			projectPath + "IndianTextBooks\\9\\Geography\\"+ "clean\\full.txt",
			projectPath + "IndianTextBooks\\9\\Science\\"+ "clean\\full.txt",
			projectPath + "IndianTextBooks\\9\\Economics\\"+ "clean\\full.txt",
			projectPath + "IndianTextBooks\\9\\History\\"+ "clean\\full.txt",
			projectPath + "IndianTextBooks\\10\\English\\"+ "clean\\full.txt",
			projectPath + "IndianTextBooks\\10\\Civics\\"+ "clean\\full.txt",
			projectPath + "IndianTextBooks\\10\\Science\\"+ "clean\\full.txt",
			projectPath + "IndianTextBooks\\10\\Economics\\"+ "clean\\full.txt",
			projectPath + "IndianTextBooks\\10\\History\\"+ "clean\\full.txt",

			
			projectPath + "US TextBooks\\1\\"+ "clean\\full.txt",
			projectPath + "US TextBooks\\2\\"+ "clean\\full.txt",
			projectPath + "US TextBooks\\3\\"+ "clean\\full.txt",
			projectPath + "US TextBooks\\4\\"+ "clean\\full.txt",
			projectPath + "US TextBooks\\5\\"+ "clean\\full.txt",
			projectPath + "US TextBooks\\6\\Geography\\"+ "clean\\full.txt",
			projectPath + "US TextBooks\\7\\History\\"+ "clean\\full.txt",
			projectPath + "US TextBooks\\8\\History\\"+ "clean\\full.txt",
			
			projectPath + "US TextBooks\\10\\Civics\\"+ "clean\\full.txt",
			projectPath + "US TextBooks\\10\\Economics\\"+ "clean\\full.txt",
			projectPath + "US TextBooks\\10\\US History\\"+ "clean\\full.txt",
			projectPath + "US TextBooks\\10\\World History\\"+ "clean\\full.txt",
		};
    public static void main (String[] args) throws java.lang.Exception
    {
        // your code goes here
    	DriverClass objDriverClass = new DriverClass();
    	objDriverClass.solve();
    	
    }
    
    public void solve() throws Exception {
    	
    	writeHeader();
        for (String filePath : paths_1)
        {
        	analyzeFileAndWriteResults(filePath);
        }
        for (String filePath : paths_2)
        {
        	analyzeFileAndWriteResults(filePath);
        }
        System.out.println("________DONE________");
    }

    private void analyzeFileAndWriteResults(String filePath) throws Exception {

	    FleschKincaid objFleschKincaid = new FleschKincaid();
	    FleschKincaid objFleschKincaidWithStanfordNLPLexer = new FleschKincaid();
	    objFleschKincaidWithStanfordNLPLexer.setSentenceLexer(new StandfordNLPSentenceLexer());
	
	
		String country = getCountry(filePath);
		String grade = getGrade(filePath);
		String subject = getSubject(filePath);
		StringBuilder out = new StringBuilder();
		
	    File file = new File(filePath);
	    ReadabilityCalculator.Stats stats = ReadabilityCalculator.analyze(file);
	    
	    String text = readFile(file);
        out.append(country).append(",");
        out.append(grade).append(",");
        out.append(subject).append(",");
        out.append(Readability.calcFlesch(stats)).append(",");
        out.append(objFleschKincaid.calculate(text.toString())).append(",");
        out.append(objFleschKincaidWithStanfordNLPLexer.calculate(text.toString())).append(",");
        

	    out.append(stats.getNumWords()).append(",");
	    out.append(stats.getNumSentences()).append(",");
	    out.append(stats.getNumSyllables()).append(",");
	    out.append(stats.getNumComplexWords()).append(",");
	    out.append(Readability.wordsPerSentence(stats)).append(",");
	    out.append(Readability.percentComplexWords(stats)).append(",");
	    out.append(Readability.syllablesPerWords(stats)).append(",");
	    
	    out.append(Readability.calcKincaid(stats)).append(",");
	    out.append(Readability.calcFog(stats)).append(",");
	    
	    
	    int words =  objFleschKincaid.getNumWords(text);
	    int sentences = objFleschKincaid.getNumSentences(text);
	    int syllables = objFleschKincaid.getNumSyllables(text);
	    out.append(words).append(",");
	    out.append(sentences).append(",");
	    out.append(syllables).append(",");
	    if(sentences==0)
	    	out.append("NA").append(",");
	    else
	    	out.append(words/sentences).append(",");
	    if(words==0)
	    	out.append("NA").append(",");
	    else
		    out.append(syllables/words).append(",");
	    

	    words =  objFleschKincaidWithStanfordNLPLexer.getNumWords(text);
	    sentences = objFleschKincaidWithStanfordNLPLexer.getNumSentences(text);
	    syllables = objFleschKincaidWithStanfordNLPLexer.getNumSyllables(text);
	    out.append(words).append(",");
	    out.append(sentences).append(",");
	    out.append(syllables).append(",");
	    if(sentences==0)
	    	out.append("NA").append(",");
	    else
	    	out.append(words/sentences).append(",");
	    if(words==0)
	    	out.append("NA").append(",");
	    else
		    out.append(syllables/words).append(",");
	    
	    
	    
	    
	    out.append(getCS7IS4wordCount(text)).append(",");
	    out.append(getCS7IS4sentenceCount(text)).append("\n");
	    
	    String resultPath = "C:\\Users\\Swastik\\Desktop\\MastersDegree_CS\\Semester_2\\TextAnalytics\\Project\\_results\\";
	    BufferedWriter writer = new BufferedWriter(
	  		  new FileWriter(resultPath +  "results.csv"));
	    writer.append(out);
	    writer.close();
		
	}
    
    private Object getCS7IS4wordCount(String text) {
    	return text.split(" ").length;
	}

	private Object getCS7IS4sentenceCount(String text) {
		return text.split(".").length;
	}

	private String readFile(File file) throws Exception
    {
        StringBuilder text = new StringBuilder();
        BufferedReader br = new BufferedReader(new FileReader(file));
    	  String st = "";
          while ((st = br.readLine()) != null)
        	  text.append(st);
        return text.toString();
    }

	private void writeHeader() throws Exception {
		
		    StringBuilder out = new StringBuilder();
		    out.append("Country").append(",");
		    out.append("Grade").append(",");
		    out.append("Subject").append(",");
		    out.append("FK_1_FK_SCORE").append(",");
		    out.append("FK_2_FK_SCORE").append(",");
		    out.append("FK_3_FK_SCORE").append(",");
		    out.append("FK_1_WORD_COUNT").append(",");
		    out.append("FK_1_SENTENCE_COUNT").append(",");
		    out.append("FK_1_SYLLABLES_COUNT").append(",");
		    out.append("FK_1_COMPLEX_WORD_COUNT").append(",");
		    out.append("FK_1_WORDS_PER_SENTENCE").append(",");
		    out.append("FK_1_PERCENTAGE_COMPLEX_WORDS").append(",");
		    out.append("FK_1_SYLLABLES_PER_WORD").append(",");
		    out.append("FK_1_ESTIMATED_GRADE").append(",");
		    out.append("FK_1_FOG_INDEX").append(",");

		    out.append("FK_2_WORD_COUNT").append(",");
		    out.append("FK_2_SENTENCE_COUNT").append(",");
		    out.append("FK_2_SYLLABLES_COUNT").append(",");
		    out.append("FK_2_WORDS_PER_SENTENCE").append(",");
		    out.append("FK_2_SYLLABLES_PER_WORD").append(",");

		    out.append("FK_3_WORD_COUNT").append(",");
		    out.append("FK_3_SENTENCE_COUNT").append(",");
		    out.append("FK_3_SYLLABLES_COUNT").append(",");
		    out.append("FK_3_WORDS_PER_SENTENCE").append(",");
		    out.append("FK_3_SYLLABLES_PER_WORD").append(",");
		    
		    
		    out.append("CS7IS4_WORD_COUNT").append(",");
		    out.append("CS7IS4_SENTENCE_COUNT").append("\n");
		    String resultPath = "C:\\Users\\Swastik\\Desktop\\MastersDegree_CS\\Semester_2\\TextAnalytics\\Project\\_results\\";
		    BufferedWriter writer = new BufferedWriter(
		  		  new FileWriter(resultPath +  "results.csv"));
		    writer.write(out.toString());
		    writer.close();
				
	}
	private String getGrade(String filePath) {
		int i = filePath.indexOf("TextBooks");
		i = filePath.indexOf("\\", i);
		int e = filePath.indexOf("\\", i+1);
		return filePath.substring(i+1, e);
	}

	private String getSubject(String filePath) {
		if(!filePath.contains("clean"))
			return "ALL";
		
		int i = filePath.indexOf("TextBooks");
		i = filePath.indexOf("\\", i);
		i = filePath.indexOf("\\", i+1);
		int e = filePath.indexOf("\\", i+1);
		return filePath.substring(i+1, e);
	}

	private String getCountry(String filePath) {
		if(filePath.contains("IndianTextBooks"))
			return "IN";
		return "US";
	}


}
