package gui.utiles;

import javafx.scene.control.TextField;

public class DoubleTextField extends TextField{

	public DoubleTextField() {		
	}
	
	public DoubleTextField(double n) {
		super.setText(""+n);
	}
	
    @Override
    public void replaceText(int start, int end, String text)
    {
        if (validate(text))
        {
            super.replaceText(start, end, text);
        }
    }

    @Override
    public void replaceSelection(String text)
    {
        if (validate(text))
        {
            super.replaceSelection(text);
        }
    }

    private boolean validate(String text)
    {
        return text.matches("[-]?[0-9]*[\\.]{0,1}?[0-9]*"); //poner bien el double, q no permita --123...123.1.123
        
    }
}
