public class Conv {

    private static char symbols[] = new char[] { '0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T' };

    public static void run ()
    {
    	
    	Conv converter = new Conv ();
    	long num1 = 0;
    	String temp = "";
    	long temp2 = 0;
    	
    	String base = (String) Gui.startBase.getSelectedItem();
    	int base1 = Integer.parseInt(base);
    	//System.out.println(base1);
    	String base_res = (String) Gui.endBase.getSelectedItem();
    	int base2 = Integer.parseInt(base_res);
    	
    	
    	if (base1 > 10){
    		temp = Gui.numToConvert.getText();
    		//System.out.println("input = " + temp);
    		try{
    		num1 = Long.valueOf(temp, base1);
    		} catch(Exception e) { System.out.println(e); 
    			Gui.resField.setText("Error: Input out of range"); }//error handling
    		Gui.resField.setText("" + num1);
    		
    	}
    	
    	else {
    		String numToConvert = Gui.numToConvert.getText();
    		try{
    		num1 = Long.parseLong(numToConvert, base1);
    		} catch(Exception e) { System.out.println(e); }
    		temp = toDec(num1, base1);
    		//System.out.println(temp);
    		try{
    		temp2 = Long.parseLong(temp);
    		} catch(Exception e) { System.out.println(e);
    		Gui.resField.setText("Error: Input out of range");} //error handling
    		
    		Gui.resField.setText(converter.convert (temp2 , base2 ));
    	}

    	
    	
    }
    
    public static String toDec(long number, int base){
    	
    	return toDec(number, base, 0, "" );
    }
    
    private static String toDec( long number, int base, int position, String result )
    {
    	long y =0;
    	int pos = 0;
    	while( number >= 1 ) {
    		y = y + (number%10) * (long) Math.pow(base, pos);
    		number = number/10;
    		pos++;}
    	
    	return Long.toString(y);
    	
    }
    
    
    public String convert ( long number, int base )
    {
        return convert(number, base, 0, "" );
    }

    private String convert ( long number, int base, int position, String result )
    {
        if ( number < Math.pow(base, position + 1) )
        {
            return symbols[(int) (number / (long)Math.pow(base, position))] + result;
        }
        else
        {
            long remainder = (number % (long)Math.pow(base, position + 1));
            return convert (  number - remainder, base, position + 1, symbols[(int) (remainder / (long)( Math.pow(base, position) ))] + result );
        }
        
    }
}