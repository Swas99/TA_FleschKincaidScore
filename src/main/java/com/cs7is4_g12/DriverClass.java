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



    public static void main (String[] args) throws java.lang.Exception
    {
        // your code goes here
    	DriverClass objDriverClass = new DriverClass();
    	objDriverClass.solve();
    }
    
    public void solve() throws Exception {
    	String projectPath = "C:\\Users\\Swastik\\Desktop\\MastersDegree_CS\\Semester_2\\TextAnalytics\\Project\\";
        String filePaths[] =
        {
        	projectPath + "US TextBooks\\10\\" + "10th_full.txt",
        	projectPath + "IndianTextBooks\\10\\" + "10th_full.txt",
        	
			projectPath + "US TextBooks\\10\\Civics\\clean\\full.txt",
			projectPath + "US TextBooks\\10\\Economics\\clean\\full.txt",
//			projectPath + "US TextBooks\\10\\US History\\clean\\full.txt",
			projectPath + "US TextBooks\\10\\World History\\clean\\full.txt",
			
			projectPath + "IndianTextBooks\\10\\Civics\\clean\\full.txt",
			projectPath + "IndianTextBooks\\10\\History\\clean\\full.txt",
			projectPath + "IndianTextBooks\\10\\Economics\\clean\\full.txt",
			

			projectPath + "US TextBooks\\6\\Geography\\clean\\full.txt",
			projectPath + "IndianTextBooks\\6\\Geography\\clean\\full.txt",
        };
        
        

        StringBuilder out = new StringBuilder();
        
        FleschKincaid objFleschKincaid = new FleschKincaid();
        
        FleschKincaid objFleschKincaidWithStanfordNLPLexer = new FleschKincaid();
        objFleschKincaidWithStanfordNLPLexer.setSentenceLexer(new StandfordNLPSentenceLexer());
 
        for (String filePath : filePaths) {
        	
        	
            File file = new File(filePath);
            ReadabilityCalculator.Stats stats = ReadabilityCalculator.analyze(file);
            
            out.append(filePath.toUpperCase()).append("\n");
            out.append("FleschKincaid Implementation 1:\n");
            out.append("--------------------------------------------------------------\n");
            out.append(stats.toString()).append("\n");
            out.append("calcFog: " + Readability.calcFog(stats)).append("\n");
            out.append("calcKincaid: " + Readability.calcKincaid(stats)).append("\n");
            out.append("wordsPerSentence: " + Readability.wordsPerSentence(stats)).append("\n");
            out.append("percentComplexWords: " + Readability.percentComplexWords(stats)).append("\n");
            out.append("syllablesPerWords: " + Readability.syllablesPerWords(stats)).append("\n");
            out.append("Flesch Score: " + Readability.calcFlesch(stats)).append("\n");
            
            StringBuilder text = new StringBuilder();
            BufferedReader br = new BufferedReader(new FileReader(file));
			  String st = "";
		      while ((st = br.readLine()) != null)
		    	  text.append(st); 

            out.append("\n\nFleschKincaid Implementation 2:\n");
            out.append("----------------------------------\n");
            out.append("Flesch Score: " + objFleschKincaid.calculate(text.toString()));

            out.append("\n\nFleschKincaid Implementation 3(StanfordNLP_Lexer):\n");
            out.append("----------------------------------\n");
            out.append("Flesch Score: " + objFleschKincaidWithStanfordNLPLexer.calculate(text.toString()));
            out.append("\n\n***********************\n\n");
        }
        
        String resultPath = "C:\\Users\\Swastik\\Desktop\\MastersDegree_CS\\Semester_2\\TextAnalytics\\Project\\_results\\";
        BufferedWriter writer = new BufferedWriter(
      		  new FileWriter(resultPath +  "result.txt"));
        writer.write(out.toString());
        writer.close();
        
    }


}
