package ex_dev;
import java.awt.List;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class exam_dev {
	private static String[] Log_list;
	 static String[] Name,DateIn,DateOut;
	static String[] TimeIn,TimeOut;
	static int count=2;
	static String Day;
	static String [] TimeIn_String,TimeOut_String=new String[2];
	static int [] TimeIn_int=new int[2];
	static int [] TimeOut_int=new int[2];
	static int OT=0;
	static double mounyTotal=0,mouny;
	static int Stats=0;
	static int TotleMin=0,barkeTime=0;
	
	
	
	public static void main(String[]args){
		
		ReadLine();
		
	}
	
	public static void ReadLine(){
		 int i=0;
		int j=0;
		String[]a;
		try{
			
			ArrayList<String> list=new ArrayList<String>(Files.readAllLines(Paths.get("C:\\Users\\Tokud\\Desktop\\Dev_Test_2016\\1.working_time.log"))); //��ҹ���
			
			 Log_list = new String[list.size()];
			 
			for( i=0;i<Log_list.length;i++){         //size()�մ�ӡѴ�ͧ�����ŷ�������list
				
				Log_list[i]=list.get(i);
				
				//System.out.println(Log_list[i]); //��ҹ��Ҩҡlog���к�÷Ѵ
				
			
					  a = Log_list[i].split("\\|");
					  
					  
			   if(a[2].matches("")){ //�ѡ��ҷ����index��ҧ �����������Դ��äӹǳ�Դ��Ҵ
					 
				  // System.out.println("It Null Index");
				   count++;
				   
				}else{ //���index����ͧ�����ҧ����Ѵ���������� (������ҷӧҹ��ѹ���)
					
					count++;  //�鹵�ǹѺ�ͺ
					
					Name= new String[count];     //��˹� ��Ҵ�ͧ���������դ������ҧ��ҡѹ�����ŷ��١�����͹���
					DateIn= new String[count];
					TimeIn= new String[count];
					DateOut= new String[count];
					TimeOut= new String[count];
					
					       Name[i] = a[0];    // ����Ңͧ���� log ������㹵�����ա���������㹡�äӹǳ����
						 DateIn[i] = a[1];
						 TimeIn[i] = a[2];
						 DateOut[i] = a[3];
						 TimeOut[i] = a[4];
						 
						 
						// System.out.println(Name[i]);      // ���ͺ��ҷ������͡��
						// System.out.println(DateIn[i]);
						// System.out.println(TimeIn[i]);
						// System.out.println(DateOut[i]);
						// System.out.println(TimeOut[i]);
						 
						 System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
						 
						///////////////////////////////////////////Time IN////////////////////////////////////////////////////////////////////////////////
						//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
						 
						 TimeIn_String = TimeIn[i].split("\\:"); //�¡������ҧҹ
						 
						 
					 TimeIn_int[0]=Integer.parseInt(TimeIn_String[0]);  //////////// �ŧʵԧ�� Int TimeIn
					 TimeIn_int[1]=Integer.parseInt(TimeIn_String[1]);  ///////////
						
					 
					 
					 ////////////////////////////////////////////////////////////////������� �Ѻ ��ҧҹ��͹����///////////////////////////////////////////////////////////////
					///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
					 if((TimeIn_int[0]==7&&TimeIn_int[1]>30)){   //  ��ҡ�͹��� �Ѵ �� 8.00
						 
						 TimeIn_int[0]=8;
						 TimeIn_int[1]=0;
						 
					 }else if((TimeIn_int[0]==8&&TimeIn_int[1]<=5)){ //�ó�����ѧ 8.00 �����֧ 8.06 ���Ѵ�� 8.00
						 TimeIn_int[0]=8;
						 TimeIn_int[1]=0;
						 
					 }
					 else if(((TimeIn_int[0]>=8&&TimeIn_int[0]<11)&&TimeIn_int[1]>=6)){ // �����͹������ �ѡ�Թ ������Թ 8.06
						
						 
					 }else if((TimeIn_int[0]>10&&TimeIn_int[1]>=0)){ //�ó���� �ҹ�� ���� �֡
						 
						Stats=1;
						
					 }
					 /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
					
					     
					 System.out.println("�س     "+Name[i] );
					 System.out.println("�ӧҹ��ѹ  "+ DateIn[i]);
					  System.out.println("��ҷӧҹ    "+TimeIn_int[0]+":"+TimeIn_int[1]+" �ҷ�");          
						 
						 
						 TimeIn_int[0]=((TimeIn_int[0]*60)+TimeIn_int[1]);
						    
						
						//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// 
						 
						
			///////////			///////////////////////////////////////////////////////////Time Out///////////////////////////////////////////////////////////////// 
			//////////			/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// 
						 TimeOut_String = TimeOut[i].split("\\:"); //�¡�����͡�ҹ
						 
			
						 
						 TimeOut_int[0]=Integer.parseInt(TimeOut_String[0]); //////////// �ŧʵԧ�� Int TimeOut
						 TimeOut_int[1]=Integer.parseInt(TimeOut_String[1]); ///////////
						 
						 
						 
						 ///////////////////////////////////////////�����͡��� OT ////////////////////////////////////////////////////////////////////
						 ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
							
	                      if((TimeOut_int[0]==17&&TimeOut_int[1]<30)){   // �͡��ѧ���һ�Ѻ�� 17.00
							 
							 TimeOut_int[0]=17;
							 TimeOut_int[1]=0;
							
						 }else if((TimeOut_int[0]>=17&&TimeOut_int[1]>=0)){ //  OT
							 	
						
							 
						 }
					////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// 
						
						
	                      
	                      
	                      
	                      
	                      System.out.println("�͡�ҹ����      "+TimeOut_int[0]+":"+TimeOut_int[1]+" �ҷ�");
			
						 
						 if((TimeIn_int[0]>=7&&TimeIn_int[1]>=0)&&(TimeOut_int[0]<13&&TimeOut_int[1]>=0)){  //�礤��ӧҹ�������ѹ
							      barkeTime=0;
	                       
	                       		
	                       }else{  //�ѡ���Ҿѡ 60 min  ����Ѻ��������ѹ
	                    	      barkeTime=-60;
	                    	 
	                        	
	                        }
						
						
						 
						 TimeOut_int[0]=((TimeOut_int[0]*60)+TimeOut_int[1]);
						
						 
						
						 
						
						 
					/////////////////////////////////////////////////////////�ӹǳ����//////////////////////////////////////////////////////////////	 
						 TotleMin=(TimeOut_int[0]-TimeIn_int[0]);
						 
						 if(TotleMin<0){  //�óշ�� ���time�͡�ҵԴź������ҧҹ��ǧ��蹷������� 8.00
							 TotleMin=TotleMin*(-1);
						 }
						 TotleMin=TotleMin+barkeTime;
                        
                       
						 
						 System.out.println("����㹡�÷ӧҹ��� (�ҷ�)  "+TotleMin+"  �ҷ� ");
						 
						 
						
						
						 
						
						
						 /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
						 
						 if(DateIn[i].matches("8/10/2015")){
							 Day="Thursday";
							
							 switch (Stats) {
								case 1: 
									   OT=TotleMin;
									   mounyTotal=OT*(0.90625); // �ó� ��������ͷ� OT   1.5 ��� OT
									  
									break;

								default:
									 if(TotleMin>=480){ //��ҷ�OT
										 
										 OT=TotleMin-480;
										 mouny=TotleMin*(0.604166666666);
										 mounyTotal=OT*(0.90625);
										 mounyTotal=mounyTotal+mouny;
									 
									 }else{
										 
										 mouny=TotleMin*(0.604166666666);
										 mounyTotal=OT*(0.90625);
										 mounyTotal=mounyTotal+mouny;
										 
									 }
									
									
									break;
								};
							 
							
							
							 
						 }else if (DateIn[i].matches("9/10/2015")){
							 Day="Friday";
							 switch (Stats) {
								case 1: 
									   OT=TotleMin;
									   mounyTotal=OT*(0.90625); // �ó� ��������ͷ� OT   1.5 ��� OT
									  
									break;

								default:
									 if(TotleMin>=480){ //��ҷ�OT
										 
										 OT=TotleMin-480;
										 mouny=TotleMin*(0.604166666666);
										 mounyTotal=OT*(0.90625);
										 mounyTotal=mounyTotal+mouny;
									 }else{
										 
										 mouny=TotleMin*(0.604166666666);
										 mounyTotal=OT*(0.90625);
										 mounyTotal=mounyTotal+mouny;
										 
									 }
									
									
									break;
								};
							 
						 }else if(DateIn[i].matches("10/10/2015")){
							 Day="Saturday";
							 switch (Stats) {
								case 1: 
									   OT=TotleMin;
									   mounyTotal=OT*(1.20833333333); // �ó� ��������ͷ� OT ��ѹ��ش  2 ��� OT
									  
									break;

								default:
									 if(TotleMin>=480){ //��ҷ�OT
										 
										 OT=TotleMin-480;
										 mouny=TotleMin*(0.90625);
										 mounyTotal=OT*(1.20833333333);
										 mounyTotal=mounyTotal+mouny;
										
									 }else{
										 mouny=TotleMin*(0.90625);
										 mounyTotal=OT*(1.20833333333);
										 mounyTotal=mounyTotal+mouny;
									 }
									
									
									break;
								};
							 
						 }
						
						 System.out.println("��OT������   "+OT+" �ҷ�");
						 System.out.println("�ӹǹ����������� ���  "+mounyTotal+" �ҷ");
						 
						 
						// System.out.println(Day);
						 Stats=0;   //�������緤�� ����鹨� BUG
						 mounyTotal=0;
						 barkeTime=0;
						 mouny=0;
						 OT=0;
						
				}
					 
					 
				
					 
				
				}
			
		}catch (IOException e){
			e.printStackTrace();
		}
		
		
	}
	

}
