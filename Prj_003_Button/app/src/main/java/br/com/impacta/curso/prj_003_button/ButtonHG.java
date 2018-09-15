package br.com.impacta.curso.prj_003_button;

/**
 * Created by nalmir on 03/02/2018.
 */

public class ButtonHG {

    public interface IButtonHG {
        void click();
    }

    private IButtonHG delegate;

    public void setOnClickListener(IButtonHG delegate) {
        this.delegate = delegate;
    }

    void performClick() {
        if (delegate != null){
            delegate.click();
        }
    }

}
