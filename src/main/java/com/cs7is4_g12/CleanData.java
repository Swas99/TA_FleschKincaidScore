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
	
    public static void main (String[] args) throws java.lang.Exception
    {
        // your code goes here
    	CleanData objCleanData = new CleanData();
    	objCleanData.clean(); 
    	
    	String base_paths[] = 
    		{
				projectPath + "US TextBooks\\6\\Geography\\",
				projectPath + "US TextBooks\\10\\Civics\\",
				projectPath + "US TextBooks\\10\\Economics\\",
				projectPath + "US TextBooks\\10\\US History\\",
				projectPath + "US TextBooks\\10\\World History\\",
				projectPath + "IndianTextBooks\\6\\Geography\\",
				projectPath + "IndianTextBooks\\10\\Civics\\",
				projectPath + "IndianTextBooks\\10\\Economics\\",
				projectPath + "IndianTextBooks\\10\\History\\",
    		};
    	for(String x : base_paths)
    		objCleanData.consolidateChapters(x); 
    	
    	String us10th[] = 
    		{
    				projectPath + "US TextBooks\\10\\Civics\\clean\\full.txt",
    				projectPath + "US TextBooks\\10\\Economics\\clean\\full.txt",
//    				projectPath + "US TextBooks\\10\\US History\\clean\\full.txt",
    				projectPath + "US TextBooks\\10\\World History\\clean\\full.txt",
    		};
    	String india10th[] = 
    		{
				projectPath + "IndianTextBooks\\10\\Civics\\clean\\full.txt",
				projectPath + "IndianTextBooks\\10\\Economics\\clean\\full.txt",
				projectPath + "IndianTextBooks\\10\\History\\clean\\full.txt",
    		};

		objCleanData.consolidatefiles(us10th,projectPath + "IndianTextBooks\\10\\" + "10th_full.txt"); 
		objCleanData.consolidatefiles(india10th,projectPath + "US TextBooks\\10\\" + "10th_full.txt"); 
    }


    public void consolidatefiles(String base_paths[],String outPath) throws Exception {
    	  
        StringBuilder out = new StringBuilder();
        for (String filePath : base_paths) 
		  {
			  try
			  {
		          File file = new File(filePath); 
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
    }  

    public void consolidateChapters(String base_path) throws Exception {
    	 
        String filePaths[] =
                {
                        "1.txt", "2.txt", "3.txt", "4.txt", "5.txt", "6.txt", "7.txt", "8.txt", "9.txt", "10.txt"
                };

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
			  }catch(Exception ignored) {}
			}
		  


          BufferedWriter writer = new BufferedWriter(
        		  new FileWriter(base_path + "clean\\" +  "full.txt"));
          writer.write(out.toString());
          writer.close();
    }  

    
    public void clean() throws Exception {
//    	String base_path = "C:\\Users\\Swastik\\Desktop\\MastersDegree_CS\\Semester_2\\TextAnalytics\\Project\\IndianTextBooks\\6\\Geography\\";
    	String base_paths[] = 
    		{
    			projectPath + "US TextBooks\\6\\Geography\\",
    			projectPath + "US TextBooks\\10\\Civics\\",
    			projectPath + "US TextBooks\\10\\Economics\\",
    			projectPath + "US TextBooks\\10\\US History\\",
    			projectPath + "US TextBooks\\10\\World History\\",
    			projectPath + "IndianTextBooks\\6\\Geography\\",
    			projectPath + "IndianTextBooks\\10\\Civics\\",
    			projectPath + "IndianTextBooks\\10\\Economics\\",
    			projectPath + "IndianTextBooks\\10\\History\\",
    		};
        String filePaths[] =
                {
                        "1.txt", "2.txt", "3.txt", "4.txt", "5.txt", "6.txt", "7.txt", "8.txt", "9.txt", "10.txt"
                };
        

		  Map<Character, Boolean> charMap = new HashMap<>();
		  for (String base_path : base_paths) 
			  for (String filePath : filePaths) 
			  {
				  try
				  {
			          File file = new File(base_path + "raw\\" + filePath); 
			          BufferedReader br = new BufferedReader(new FileReader(file));
			          String st = "";
			          StringBuilder out = new StringBuilder();
			          while ((st = br.readLine()) != null)
			        	out.append(st); 
			          
			          String text = out.toString();
			          String replace[] = {
			        		  "&" , "}" , "{" , ";" , ":" , "_" ,
			          };
			          String exclude[] = {
			        		  "" , "/" , "�" ,
			          };
			          String keep[] = {
			        		  "!" , "%" , "-" , 
			        		  "'" , "+" , "," , "=" , "?" , "(" , ")" , "." ,
			        		  " " ,
	//		        		  "0" , "1" , "2" , "3" , "4" , "5" , "6" , "7" , "8" , "9" ,
	//		        		  "A" , "B" , "C" , "D" , "E" , "F" , "G" , "H" , "I" , "J" , "K" ,
	//		        		  "L" , "M" , "N" , "O" , "P" , "Q" , "R" , "S" , "T" , "U" , "V" ,
	//		        		  "W" , "X" , "Y" , "Z" ,
	//		        		  "a" , "b" , "c" , "d" , "e" , "f" , "g" , "h" , "i" , "j" ,
	//		        		  "k" , "l" , "m" , "n" , "o" , "p" , "q" , "r" , "s" , "t" , "u" ,
	//		        		  "v" , "w" , "x" , "y" , "z" ,
			          };
			          
			          text = text.replace("&", "and");
			          text = text.replace("{", "(");
			          text = text.replace("}", ")");
			          text = text.replace(";", ".");
			          text = text.replace(":", ".");
			          text = text.replace("_", "-");
			          text = text.replace("Interactive", ".");
			          text = text.replace("Shutterstock", ".");
			          List<Character> excludeList = new ArrayList<>();
			          excludeList.add('�');
			          excludeList.add('/');
			          excludeList.add('');
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
		        	  text = removeLongWords(text, 26);
		        	  text = removeShortSentences(text, 8).trim();
	
			          for(char x : text.toCharArray())
			          {
		          		if(!charMap.containsKey(x))
		          			charMap.put(x, true);
			          } 
	//	        	  System.out.println(text);
		        	  System.out.println(text.split(" ").length);
		        	  System.out.println();
		        	  
	
		              BufferedWriter writer = new BufferedWriter(
		            		  new FileWriter(base_path + "clean\\" +  filePath));
		              writer.write(text);
		              writer.close();
				  }catch(Exception ignored) {}
			    }

//    	  System.out.println();
//	      for(char x : charMap.keySet())
//	    	  System.out.print("\"" + x + "\" , ");
    }  

    public String removeShortSentences(String s, int threshold)
    {
    	StringBuilder sb = new StringBuilder();
    	s = s.replace(".", "#_#");
    	s = s.replace("!", "#_#");
    	s = s.replace("?", "#_#");
    	String sentences[] = s.split("#_#");
    	System.out.println("sentences= " + sentences.length);
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
    	System.out.println("wwords= " + words.length);
    	for(String word: words)
    	{
    		if(isAllCaps(word))
    			continue;
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
    	if(s.length()<2)
    		return false;
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
