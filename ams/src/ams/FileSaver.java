/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ams;

import java.io.File;
import java.io.FileWriter;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/** File exporter class (Exporting the student list)
 *
 * @author Maan Alaulaqi (201610814@aau.ac.ae)
 */
public class FileSaver {
    
    public FileSaver(){}
    
    public static void SaveMe(String x, String y) {
		String sb = x;
		JFileChooser chooser = new JFileChooser();
		chooser.setSelectedFile(new File(y));
                String userDir = System.getProperty("user.home");
		chooser.setCurrentDirectory(new File(userDir + "/Desktop"));
		File file = new File (chooser.getSelectedFile().toString() + ".xls");
		//boolean s = file.exists();
		int retrival = chooser.showSaveDialog(null);
		if (retrival == JFileChooser.APPROVE_OPTION) {
			try {
			FileWriter fw = new FileWriter(chooser.getSelectedFile()+".xls");
//                      if (s) {
//                          int response = JOptionPane.showConfirmDialog(null, //
//                          "Do you want to replace the existing file?", //
//                          "Confirm", JOptionPane.YES_NO_OPTION, //
//                          JOptionPane.QUESTION_MESSAGE);
//                          if (response != JOptionPane.YES_OPTION) {
//                              return;
//                          } 
//                      } 
				fw.write(sb.toString());
				fw.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}
    
}
