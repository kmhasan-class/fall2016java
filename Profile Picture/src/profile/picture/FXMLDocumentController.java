/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package profile.picture;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;

/**
 *
 * @author kmhasan
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private ImageView imageView;
    @FXML
    private Label imageLabel;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        Image image = new Image("http://www.seu.ac.bd/dept/dept_images/cse/Rakibul.jpg");
        imageView.setImage(image);
        imageLabel.setText("Md. Rakibul Hasan");
    }    

    @FXML
    private void handleOpenFileAction(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        File file = fileChooser.showOpenDialog(null);
       
        Image image = new Image("file://" + file.getAbsolutePath());
        imageView.setImage(image);
        imageLabel.setText(file.getName());
    }
    
}
