package com.db.qryreader;


	import java.io.FileInputStream;
	import java.io.FileOutputStream;
	import java.util.Scanner;
	import java.io.*;
	import java.text.SimpleDateFormat;  
	import java.util.Date;  


			public class csvfile extends dbtest {
				int id;
				int season;
				String city;
				Date date;
				String team1;
				String team2;
				String toss_winner;
				String toss_decision;
				String result;
				int dl_applied;
				String winner;
				int win_by_runs;
				int win_by_wickets;
				String player_of_match;
				String venue;
				String umpire1;
				String umpire2;
				String umpire3;
			
				

		
			    public void filereader() throws Exception {
			       String[] f=new String[100000];
			       String[][] td=new String[10000][10000];
			       int p=0,k=0;
			       try
			       {
			       FileReader ip=new FileReader("ipl.csv");
			       try
			       {
			       Scanner parser=new Scanner(ip);
			       while(parser.hasNextLine())
			       {
			           String line=parser.nextLine();
			           String[] att=line.split(",");
			           for(int q=0;q<att.length;q++)
			           {
			               f[p]=att[q];
			               p++;
			           }
			       }
			       }
			       finally
			       {
			           ip.close();
			       }
			       }
			       catch(FileNotFoundException ex)
			       {
			           System.out.println("File not found "+ex);
			       }
			       catch(IOException ex)
			       {
			           System.out.println("Unexpected I/O error "+ex);
			       }
			       
			       
			      for(int i=0;i<578;i++)
			      {
			          for(int j=0;j<18;j++)
			          {
			              td[i][j]=f[k];
			              k++;
			          }
			      }
			     
			      
			      csvfile[] obj=new csvfile[578];
			      for (int i=1;i<=577;i++)
			         obj[i]= new csvfile();
			      try {
			      for (int i=1;i<=577;i++)
			      {
			    	  obj[i].id=Integer.parseInt(td[i][0]);
			    	  obj[i].season=Integer.parseInt(td[i][1]);
			    	  obj[i].city=td[i][2];
			    	  obj[i].date=new SimpleDateFormat("yyyy-MM-dd").parse(td[i][3]);
			    	  obj[i].team1=td[i][4];
			    	  obj[i].team2=td[i][5];
			    	  obj[i].toss_winner=td[i][6];
			    	  obj[i].toss_decision=td[i][7];
			    	  obj[i].result=td[i][8];
			    	  obj[i].dl_applied=Integer.parseInt(td[i][9]);
			    	  obj[i].winner=td[i][10];
			    	  obj[i].win_by_runs=Integer.parseInt(td[i][11]);
			    	  obj[i].win_by_wickets=Integer.parseInt(td[i][12]);
			    	  obj[i].player_of_match=td[i][13];
			    	  obj[i].venue=td[i][14];
			    	  obj[i].umpire1=td[i][15];
			    	  obj[i].umpire2=td[i][16];
			    	  obj[i].umpire3=td[i][17];
			      }
			      }
			      catch(NumberFormatException ex){ 
			    	  System.out.println(ex);
			    	   
			    	}
			      
			    	  /*for (int i=1;i<=577;i++)
				      {
				    	  System.out.println(obj[i].id);
				    	  System.out.println(obj[i].season);
				    	  System.out.println(obj[i].city);
				    	  System.out.println(obj[i].date);
				    	  System.out.println(obj[i].team1);
				    	  System.out.println(obj[i].team2);
				    	  System.out.println(obj[i].toss_winner);
				    	  System.out.println(obj[i].toss_decision);
				    	  System.out.println(obj[i].result);
				    	  System.out.println(obj[i].dl_applied);
				    	  System.out.println(obj[i].winner);
				    	  System.out.println(obj[i].win_by_runs);
				    	  System.out.println(obj[i].win_by_wickets);
				    	  System.out.println(obj[i].player_of_match);
				    	  System.out.println(obj[i].venue);
				    	  System.out.println(obj[i].umpire1);
				    	  System.out.println(obj[i].umpire2);
				    	  System.out.println(obj[i].umpire3);
				      }*/
		      
			    	 
		    	    

			    	 
			    	  FileReader ip1 = new FileReader("ipl.csv");
			    	  Scanner sc1 = new Scanner(ip1);
			    	  String hdr = sc1.nextLine();
			    	  String[] header = hdr.split(",");
			    	  
			    	  
			    	  
			    	  queryparameter qry1 = new queryparameter();
			    	  String[] field = qry1.aggselp(spqry);
			    	  
			    	  String[] cond = qry1.restrictions(spqry, qry);
			    	  String con = cond[0];
			    	 
			    	  String[] con2= con.split(" ");
			    	  
			    	  String condition1 = con2[0];
			    	  
			    	 String condition2 = con2[1];
			    	  System.out.println(con);
			    	  
			    	  String condition3 = con2[2];
			    	  
			    	  
			    	 solvequery so = new solvequery();
			    	  so.execute(header,field[0],td,condition1,condition2,condition3);
			    	      
			    	    
			    	    
			    }
				
			    
			}

