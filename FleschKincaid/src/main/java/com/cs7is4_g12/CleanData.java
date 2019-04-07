package com.cs7is4_g12;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CleanData {

	final static String projectPath = "C:\\Users\\Swastik\\Desktop\\MastersDegree_CS\\Semester_2\\TextAnalytics\\Project\\";

	final static String base_paths[] = 
		{
			projectPath + "IndianTextBooks\\1\\English\\",
			projectPath + "IndianTextBooks\\2\\English\\",
			projectPath + "IndianTextBooks\\3\\English\\",
			projectPath + "IndianTextBooks\\3\\EVS\\",
			projectPath + "IndianTextBooks\\4\\English\\",
			projectPath + "IndianTextBooks\\4\\EVS\\",
			projectPath + "IndianTextBooks\\5\\English\\",
			projectPath + "IndianTextBooks\\5\\EVS\\",
			projectPath + "IndianTextBooks\\6\\English\\",
			projectPath + "IndianTextBooks\\6\\Civics\\",
			projectPath + "IndianTextBooks\\6\\Geography\\",
			projectPath + "IndianTextBooks\\6\\History\\",
			projectPath + "IndianTextBooks\\6\\Science\\",
			projectPath + "IndianTextBooks\\7\\English\\",
			projectPath + "IndianTextBooks\\7\\Civics\\",
			projectPath + "IndianTextBooks\\7\\Geography\\",
			projectPath + "IndianTextBooks\\7\\Science\\",
			projectPath + "IndianTextBooks\\8\\English\\",
			projectPath + "IndianTextBooks\\8\\Civics\\",
			projectPath + "IndianTextBooks\\8\\Geography\\",
			projectPath + "IndianTextBooks\\8\\Science\\",
			projectPath + "IndianTextBooks\\9\\English\\",
			projectPath + "IndianTextBooks\\9\\Civics\\",
			projectPath + "IndianTextBooks\\9\\Geography\\",
			projectPath + "IndianTextBooks\\9\\Science\\",
			projectPath + "IndianTextBooks\\9\\Economics\\",
			projectPath + "IndianTextBooks\\9\\History\\",
			projectPath + "IndianTextBooks\\10\\English\\",
			projectPath + "IndianTextBooks\\10\\Civics\\",
			projectPath + "IndianTextBooks\\10\\Science\\",
			projectPath + "IndianTextBooks\\10\\Economics\\",
			projectPath + "IndianTextBooks\\10\\History\\",

			
			projectPath + "US TextBooks\\1\\",
			projectPath + "US TextBooks\\2\\",
			projectPath + "US TextBooks\\3\\",
			projectPath + "US TextBooks\\4\\",
			projectPath + "US TextBooks\\5\\",
			projectPath + "US TextBooks\\6\\Geography\\",
			projectPath + "US TextBooks\\7\\History\\",
			projectPath + "US TextBooks\\8\\History\\",
			
			projectPath + "US TextBooks\\10\\Civics\\",
			projectPath + "US TextBooks\\10\\Economics\\",
			projectPath + "US TextBooks\\10\\US History\\",
			projectPath + "US TextBooks\\10\\World History\\",
		};
	final String filePaths[] =
	{
    		"1.txt", "2.txt", "3.txt", "4.txt", "5.txt", "6.txt", "7.txt", "8.txt", "9.txt", "10.txt",
    		"11.txt", "12.txt", "13.txt", "14.txt", "15.txt", "16.txt", "17.txt", "18.txt", "19.txt", "20.txt",
    		"21.txt", "22.txt", "23.txt", "24.txt", "25.txt", "26.txt", "27.txt", "28.txt", "29.txt", "30.txt",
    };
	
	public static void main (String[] args) throws java.lang.Exception
    {
        // your code goes here
    	CleanData objCleanData = new CleanData();
    	objCleanData.clean(); 
    	
    	
    	for(String x : base_paths)
    		objCleanData.consolidateChapters(x); 

    	objCleanData.consolidateAllSubjectsForGrade();
    }


    private void consolidateAllSubjectsForGrade() {
    	String in_1[] =
    		{
    				projectPath + "IndianTextBooks\\1\\English\\",
    		};
	    String in_2[] =
	    		{
	    				projectPath + "IndianTextBooks\\2\\English\\",
	    		};
	    String in_3[] =
	    		{
	    				projectPath + "IndianTextBooks\\3\\English\\",
	    				projectPath + "IndianTextBooks\\3\\EVS\\",
	    		};
	    String in_4[] =
	    		{
	    				projectPath + "IndianTextBooks\\4\\English\\",
	    				projectPath + "IndianTextBooks\\4\\EVS\\",
	    		};
	    String in_5[] =
	    		{
	    				projectPath + "IndianTextBooks\\5\\English\\",
	    				projectPath + "IndianTextBooks\\5\\EVS\\",
	    		};
	    String in_6[] =
	    		{
	    				projectPath + "IndianTextBooks\\6\\English\\",
	    				projectPath + "IndianTextBooks\\6\\Civics\\",
	    				projectPath + "IndianTextBooks\\6\\Geography\\",
	    				projectPath + "IndianTextBooks\\6\\History\\",
	    				projectPath + "IndianTextBooks\\6\\Science\\",
	    		};
	    String in_7[] =
	    		{
	    				projectPath + "IndianTextBooks\\7\\English\\",
	    				projectPath + "IndianTextBooks\\7\\Civics\\",
	    				projectPath + "IndianTextBooks\\7\\Geography\\",
	    				projectPath + "IndianTextBooks\\7\\Science\\",
	    		};
	    String in_8[] =
	    		{
	    				projectPath + "IndianTextBooks\\8\\English\\",
	    				projectPath + "IndianTextBooks\\8\\Civics\\",
	    				projectPath + "IndianTextBooks\\8\\Geography\\",
	    				projectPath + "IndianTextBooks\\8\\Science\\",
	    		};
	    String in_9[] =
	    		{
	    				projectPath + "IndianTextBooks\\9\\English\\",
	    				projectPath + "IndianTextBooks\\9\\Civics\\",
	    				projectPath + "IndianTextBooks\\9\\Geography\\",
	    				projectPath + "IndianTextBooks\\9\\Science\\",
	    				projectPath + "IndianTextBooks\\9\\Economics\\",
	    				projectPath + "IndianTextBooks\\9\\History\\",
	    		};
	    String in_10[] =
	    		{
	    				projectPath + "IndianTextBooks\\10\\English\\",
	    				projectPath + "IndianTextBooks\\10\\Civics\\",
	    				projectPath + "IndianTextBooks\\10\\Science\\",
	    				projectPath + "IndianTextBooks\\10\\Economics\\",
	    				projectPath + "IndianTextBooks\\10\\History\\",
	    		};
	    String us_1[] =
	    		{
	    				projectPath + "US TextBooks\\1\\",
	    		};
	    String us_2[] =
	    		{
	    				projectPath + "US TextBooks\\2\\",
	    		};
	    String us_3[] =
	    		{
	    				projectPath + "US TextBooks\\3\\",
	    		};
	    String us_4[] =
	    		{
	    				projectPath + "US TextBooks\\4\\",
	    		};
	    String us_5[] =
	    		{
	    				projectPath + "US TextBooks\\5\\",
	    		};
	    String us_6[] =
	    		{
	    				projectPath + "US TextBooks\\6\\Geography\\",
	    		};
	    String us_7[] =
	    		{
	    				projectPath + "US TextBooks\\7\\History\\",
	    		};
	    String us_8[] =
	    		{
	    				projectPath + "US TextBooks\\8\\History\\",
	    		};
	    String us_10[] =
	    		{
	    				projectPath + "US TextBooks\\10\\Civics\\",
	    				projectPath + "US TextBooks\\10\\Economics\\",
	    				projectPath + "US TextBooks\\10\\US History\\",
	    				projectPath + "US TextBooks\\10\\World History\\",
	    		};

	    consolidatefiles(in_1, projectPath + "IndianTextBooks\\1\\" + "1_full.txt");
	    consolidatefiles(in_2, projectPath + "IndianTextBooks\\2\\" + "2_full.txt");
	    consolidatefiles(in_3, projectPath + "IndianTextBooks\\3\\" + "3_full.txt");
	    consolidatefiles(in_4, projectPath + "IndianTextBooks\\4\\" + "4_full.txt");
	    consolidatefiles(in_5, projectPath + "IndianTextBooks\\5\\" + "5_full.txt");
	    consolidatefiles(in_6, projectPath + "IndianTextBooks\\6\\" + "6_full.txt");
	    consolidatefiles(in_7, projectPath + "IndianTextBooks\\7\\" + "7_full.txt");
	    consolidatefiles(in_8, projectPath + "IndianTextBooks\\8\\" + "8_full.txt");
	    consolidatefiles(in_9, projectPath + "IndianTextBooks\\9\\" + "9_full.txt");
	    consolidatefiles(in_10, projectPath + "IndianTextBooks\\10\\" + "10_full.txt");
		consolidatefiles(us_1, projectPath + "US TextBooks\\1\\" + "1_full.txt");
		consolidatefiles(us_2, projectPath + "US TextBooks\\2\\" + "2_full.txt");
		consolidatefiles(us_3, projectPath + "US TextBooks\\3\\" + "3_full.txt");
		consolidatefiles(us_4, projectPath + "US TextBooks\\4\\" + "4_full.txt");
		consolidatefiles(us_5, projectPath + "US TextBooks\\5\\" + "5_full.txt");
		consolidatefiles(us_6, projectPath + "US TextBooks\\6\\" + "6_full.txt");
		consolidatefiles(us_7, projectPath + "US TextBooks\\7\\" + "7_full.txt");
		consolidatefiles(us_8, projectPath + "US TextBooks\\8\\" + "8_full.txt");
//		consolidatefiles(us_9, projectPath + "US TextBooks\\9\\" + "9_full.txt");
		consolidatefiles(us_10, projectPath + "US TextBooks\\10\\" + "10_full.txt");
	}


	public static void consolidatefiles(String base_paths[],String outPath) {
    	try
    	{
    		  StringBuilder out = new StringBuilder();
    	        for (String filePath : base_paths) 
    			  {
    				  try
    				  {
    			          File file = new File(filePath + "clean\\full.txt"); 
    					  BufferedReader br = new BufferedReader(new FileReader(file));
    					  String st = "";
    				      while ((st = br.readLine()) != null)
    				    	 out.append(st); 
    				  }catch(Exception ignored) {}
    				}
    	          BufferedWriter writer = new BufferedWriter(
    	        		  new FileWriter(outPath));
    	          writer.write(out.toString());
    	          writer.close();
    	          
    	}catch (Exception e)
    	{
    		System.out.println("Error at consolidating file!\n" + outPath);
    	}
    }  

    public void consolidateChapters(String base_path) throws Exception {
    	  

        StringBuilder out = new StringBuilder();
        for (String filePath : filePaths) 
	  {
		  try
		  {
	          File file = new File(base_path + "clean\\" + filePath); 
			  BufferedReader br = new BufferedReader(new FileReader(file));
			  String st = "";
		      while ((st = br.readLine()) != null)
		    	 out.append(st); 
		      out.append("\n");
		  }catch(Exception ignored) {}
		}
		  


          BufferedWriter writer = new BufferedWriter(
        		  new FileWriter(base_path + "clean\\" +  "full.txt"));
          writer.write(out.toString());
          writer.close();
    }  

    
    public void clean() throws Exception {
//    	
	  for (String base_path : base_paths) 
	  {
		  for (String filePath : filePaths) 
		  {
			  cleanFile(base_path, filePath);
		  }
	  }
    }  

    private void cleanFile(String base_path, String filePath) {

  	  Map<Character, Boolean> charMap = new HashMap<>();
    	try
		  {
	          File file = new File(base_path + "raw\\" + filePath); 
	          BufferedReader br = new BufferedReader(new FileReader(file));
	          String st = "";
	          StringBuilder out = new StringBuilder();
	          while ((st = br.readLine()) != null)
	        	out.append(st); 
	          
	          String text = out.toString();
	          String keep[] = {
	        		  "!" , "%" , "-" , 
	        		  "'" , "+" , "," , "=" , "?" , "(" , ")" , "." ,
	        		  " " ,
//	        		  "0" , "1" , "2" , "3" , "4" , "5" , "6" , "7" , "8" , "9" ,
//	        		  "A" , "B" , "C" , "D" , "E" , "F" , "G" , "H" , "I" , "J" , "K" ,
//	        		  "L" , "M" , "N" , "O" , "P" , "Q" , "R" , "S" , "T" , "U" , "V" ,
//	        		  "W" , "X" , "Y" , "Z" ,
//	        		  "a" , "b" , "c" , "d" , "e" , "f" , "g" , "h" , "i" , "j" ,
//	        		  "k" , "l" , "m" , "n" , "o" , "p" , "q" , "r" , "s" , "t" , "u" ,
//	        		  "v" , "w" , "x" , "y" , "z" ,
	          };
	          
	          text = text.replace("&", "and");
	          text = text.replace("{", "(");
	          text = text.replace("}", ")");
	          text = text.replace("[", "(");
	          text = text.replace("]", ")");
	          text = text.replace(";", ".");
	          text = text.replace(":", ".");
	          text = text.replace("_", "-");
	          text = text.replace("-", " ");
	          text = text.replace("Interactive", ".");
	          text = text.replace("Shutterstock", ".");
	          List<Character> excludeList = new ArrayList<>();
	          excludeList.add('�');
	          excludeList.add('/');
	          excludeList.add('');
	          excludeList.add('Ö');
	          excludeList.add('\n');
	          excludeList.add('\r');
	          excludeList.add('\t');
	          out = new StringBuilder();
	          char prevChar = 'a';
	          for(char x : text.toCharArray())
	          {
	        	  if(excludeList.contains(x) )
	        		  continue;
	        	  if(prevChar == ' ' && x == ' ')
	        		  continue;
	        	  if(prevChar == '.' && x == '.')
	        		  continue;
	        	  out.append(x);
	          } 
      	  text = removeFloatingNumbers(out.toString());
      	  text = removeAllCaps(text);
      	  text = removeLongWords(text, 20);
      	  text = removeShortSentences(text, 8).trim();
      	  text = removeConsecutiveRepetition(text);
      	  text = removeSingleLowerCaseChar(text);

	          for(char x : text.toCharArray())
	          {
        		if(!charMap.containsKey(x))
        			charMap.put(x, true);
	          } 
//      	  System.out.println(text);
//      	  System.out.println(text.split(" ").length);
//      	  System.out.println();
      	  

            BufferedWriter writer = new BufferedWriter(
          		  new FileWriter(base_path + "clean\\" +  filePath));
            writer.write(text);
            writer.close();
            System.out.println("Done: " + base_path + filePath);
		  }catch(Exception ignored) {
//			  System.out.println("Error: " + base_path + filePath);  
		  }
	}


	private String removeSingleLowerCaseChar(String s) {
	  StringBuilder sb = new StringBuilder();
    	String words[] = s.split(" ");
    	
    	for(String word: words)
    	{
    		if(word.length() == 1)
    		{
    			char x = word.charAt(0);
    			if(x>='a' && x<='z')
    				continue;
    		}

    		if(word.isEmpty())
    			continue;
    		
    		sb.append(word.trim()).append(" ");
    	}
    	return sb.toString().trim();
	}


	public String removeShortSentences(String s, int threshold)
    {
    	StringBuilder sb = new StringBuilder();
    	s = s.replace(".", "#_#");
    	s = s.replace("!", "#_#");
    	s = s.replace("?", "#_#");
    	String sentences[] = s.split("#_#");
//    	System.out.println("sentences= " + sentences.length);
    	for(String sentence: sentences)
    	{
    		if(sentence.split(" ").length<threshold)
    			continue;
    		sb.append(sentence.trim()).append(". ");
    	}
    	return sb.toString().trim();
    }
	public String removeAllCaps(String s)
    {
    	StringBuilder sb = new StringBuilder();
    	String words[] = s.split(" ");
//    	System.out.println("wwords= " + words.length);
    	for(String word: words)
    	{
    		
    		if(s.length() == 1 && !isAllCaps(s))
    			continue; //Remove non-upper-case single characters 
    		else if(isAllCaps(word) || word == null || word.isEmpty())
    			continue;
    		
    		sb.append(word.trim()).append(" ");
    	}
    	return sb.toString().trim();
    }
	public String removeConsecutiveRepetition(String s)
    {
    	StringBuilder sb = new StringBuilder();
    	String words[] = s.split(" ");
    	String prevWord = "";
    	for(String word: words)
    	{
    		if(word.contentEquals(prevWord))
    			continue;
    		prevWord = word;
    		sb.append(word.trim()).append(" ");
    	}
    	return sb.toString().trim();
    }
    public String removeLongWords(String s, int threshold)
    {
    	StringBuilder sb = new StringBuilder();
    	String words[] = s.split(" ");
    	for(String word: words)
    	{
    		if(word.trim().length()>=threshold)
    			continue;
    		sb.append(word.trim()).append(" ");
    	}
    	return sb.toString().trim();
    }
    public boolean isAllCaps(String s)
    {
    	for(char x : s.toCharArray())
    	{
    		if(!(x>='A' && x<='Z') && (!isNumber(x)))
    			return false;
    	}
    	return true;
    }

    public String removeFloatingNumbers(String s)
    {
    	if(s.isEmpty())
    		return s;
    	
    	int l = s.length();
    	StringBuilder sb = new StringBuilder();
    	
    	int i = 1;
    	sb.append(s.charAt(0));
    	for(;i<(l-1);i++)
    	{
    		if(s.charAt(i) == '.' && 
    				isNumber(s.charAt(i-1)) && isNumber(s.charAt(i+1)))
    			continue;
    		sb.append(s.charAt(i));
    	}
    	sb.append(s.charAt(i));
    	return sb.toString().trim();
    }
    
    public boolean isNumber(char x)
    {
    	if(x>='0' && x<='9')
    		return true;
    	return false;
    }
    
}
