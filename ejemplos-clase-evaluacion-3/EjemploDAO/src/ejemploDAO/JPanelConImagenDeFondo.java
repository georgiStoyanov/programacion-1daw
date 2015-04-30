package ejemploDAO;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class JPanelConImagenDeFondo extends JPanel{

    private Image _imagen;
    private boolean _fitImage;
    
    public boolean isAjustaImagen() {
        return _fitImage;
    }

    public void setAjustaImagen(boolean fitImage) {
        _fitImage = fitImage;
    }

    public void setImage( Image i ){
        _imagen = i;
        super.setOpaque(false);
    }
    
    public void setImage( String s ){
        boolean success = false;
        try{
            setImage( new URL(s) );
            System.out.println("La imagen funciona como URL");
            success = true;
        }
        catch( IOException e ){
        }
        if( success ) return;

        try{
            setImage( new File(s) );
            System.out.println("La imagen funciona como FILE");
            success = true;
        }
        catch( IOException e ){
        }
        if( success ) return;
        
        try{
            setImage( getClass().getResource(s) );
            System.out.println("La imagen funciona como recurso");

            success = true;
        }
        catch( IOException e ){
        }
        if( success ) return;
        
        System.out.println("La imagen no funciona:" + s );

    }

    public void setImage( InputStream in ) throws IOException{
       setImage( ImageIO.read(in) );
    }

    
    public void setImage( URL u ) throws IOException{
        setImage( ImageIO.read(u) );
    }

    
    public void setImage( File f ) throws IOException{
        setImage( ImageIO.read(f) );
    }
    
    @Override
    public void paint(Graphics g) {
        paintImagenDeFondo(g);
        super.paint(g);
    }

    private void paintImagenDeFondo(Graphics g) {
        if( _imagen != null ){
            if( isAjustaImagen() ){
                g.drawImage(_imagen, 0, 0, getWidth(), getHeight(), null );
            }
            else{
                g.drawImage(_imagen, 0, 0, null );
            }
        }
    }
    
    @Override
    public void setOpaque(boolean isOpaque) {
        super.setOpaque(false);
    }
}
