package excelReader;



public class dynamicdata extends Excelreader {
	
	
	
	public String urlpicker(String value)
	{
		
		excelpath("./Files/Datas.xlsx");
		
		String sr1 ;
		String sr3 = value;
		String	Output = null;
		
		for(int i=0;i<=excelcellcount(0);i++)
		{
			sr1= excelreader(0,i,1);
			
			
			if(sr1.contains(sr3))
			{

				Output= excelreader(0,i,2);
				
				break;
				
			} 
			
			
			
		}
		
		return Output;
		
	}
	
	
	public void urlpicker1()
	{
		

		for(int i=0;i<=15;i++)
		{
			String sr1 = excelreader(0,i,1);
			
			System.out.println(sr1);
			
			} 
			
			
		
		
		
		
	}
	
		

}
