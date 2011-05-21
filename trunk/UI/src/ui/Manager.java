/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.io.File;
import dataExtraction.DocumentReader;
import ComparisonEngine.ShingleCloudAlgorithm;
import ComparisonEngine.CosineSimilarityAlgorithm;
import java.io.IOException;
import java.util.ArrayList;
import ComparisonEngine.ComparisonResult;
import de.tud.kom.stringmatching.shinglecloud.ShingleCloudMatch;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.didion.jwnl.JWNLException;
import preprocess.*;

/**
 *
 * @author Compaq
 */
public class Manager {

    
    ComparisonResult cr = new ComparisonResult();
    CosineSimilarityAlgorithm cossim = new CosineSimilarityAlgorithm();
    DocumentReader docreader = new DocumentReader();
    StopWordRemover stopremover = new StopWordRemover();
    SynonymReplacer synReplaser = new SynonymReplacer();
    Stemmer stem = new Stemmer();

    public String[][] manage(String fileFolder) throws IOException, JWNLException {

        File dir = new File(fileFolder);
        String[] children = dir.list();
        HashMap hm = new HashMap();
        int fileNo=0;
        String[][] filenameText = new String[children.length*children.length][4];
        System.out.println("Size of the files is"+children.length);
        if (children == null) {
            // Either dir does not exist or is not a directory
            return null;
        }
        else {
            for (int i = 0; i < children.length; i++) {
                // Get filename of file or directory
                String filename = children[i];
                String preprocessText = preprocessText(filename,fileFolder);
                hm.put(filename, preprocessText);

            }
            for (int i = 0; i < children.length; i++) {
                for (int j = 0; j < children.length; j++) {
                    ShingleCloudAlgorithm sca = new ShingleCloudAlgorithm();
                    if(i!=j){
                    float output = sca.getSimilarity(hm.get(children[i]).toString(), hm.get(children[j]).toString());
                    String match = sca.getList();
                    String firstFile = fileFolder + File.separator + children[i];
                    String secondFile = fileFolder + File.separator + children[j];
                    System.out.println(firstFile);
                    System.out.println(secondFile);
                    //System.out.println("the string of the first text is" + hm.get(children[i]).toString( ));
                   // System.out.println("the string of the second text is" + hm.get(children[j]).toString( ));                    
                    System.out.println("match is "+ match);
                    System.out.println("Size of the fileNop is"+fileNo);
                    if(!match.isEmpty()){
                             //////////////// just for testing purposes
                    filenameText[fileNo][0] = firstFile;
                    filenameText[fileNo][1] = secondFile;
                    filenameText[fileNo][2] = match;
                    fileNo++;
                        
                    String Isplagarised = null;
                    if (output > 1.5) {
                        Isplagarised = "1";
                    }
                    else {
                        Isplagarised = "0";
                    }
                   // filenameText[i][3] = Isplagarised;
                        }
                }
                }
            }
            return filenameText;
        }

    }


    public String[][] compareFiles(String fileName,String downloadedFilePath, ArrayList<String> indexedFiles) throws IOException{


        String documentToCompare= fileName;
        String downloadedFolderPath=downloadedFilePath;
        ArrayList<String> preIndexedFiles= indexedFiles;
        File downloadedFiles = new File(downloadedFolderPath);
        String[] children =  downloadedFiles.list();

        System.out.println("document to compare is"+ fileName );


        for(int i=0;i<children.length;i++){
             System.out.println("document downloaded "+i+" "+ children[i] );
        }
        for(int i=0;i<indexedFiles.size();i++){
             System.out.println("document indexed "+i+" "+indexedFiles.get(i) );
        }
        
        HashMap hm = new HashMap();
        int fileNo=0;

        String[][] filenameText = new String[children.length*children.length][4];

        String preprocessTextOfTheComparisonFile = preprocessText(documentToCompare);

        for (int i = 0; i < children.length; i++) {
               
                String downloadedFileName = children[i];
                String preprocessText = preprocessText(downloadedFileName,downloadedFolderPath);
                hm.put(downloadedFileName, preprocessText);
            }

        for(int i=0;i< preIndexedFiles.size();i++){

            String preprocessText = preprocessText(preIndexedFiles.get(i));
            hm.put(preIndexedFiles.get(i), preprocessText);

        } 

        for (int i = 0; i < children.length; i++) {

                    ShingleCloudAlgorithm sca = new ShingleCloudAlgorithm();
                    float output = sca.getSimilarity(preprocessTextOfTheComparisonFile, hm.get(children[i]).toString());
                    String match = sca.getList();
                    String firstFile = documentToCompare;
                    String secondFile = downloadedFolderPath+File.separator+ children[i];
                    System.out.println();
                    System.out.println(firstFile);
                    System.out.println(secondFile);
                    System.out.println("the string of the first text is " + preprocessTextOfTheComparisonFile);
                    System.out.println("the string of the second text is " + hm.get(children[i]).toString());
                    System.out.println("match is "+ match);
                    System.out.println("Size of the matched files is "+fileNo);
                    System.out.println();
                    if(!match.isEmpty()){
                             //////////////// just for testing purposes
                    filenameText[fileNo][0] = firstFile;
                    filenameText[fileNo][1] = secondFile;
                    filenameText[fileNo][2] = match;
                    fileNo++;

                    String Isplagarised = null;
                    if (output > 1.5) {
                        Isplagarised = "1";
                    }
                    else {
                        Isplagarised = "0";
                    }
                   // filenameText[i][3] = Isplagarised;
                        }

                }


        for(int i=0;i< preIndexedFiles.size();i++){

                    ShingleCloudAlgorithm sca = new ShingleCloudAlgorithm();
                    float output = sca.getSimilarity(preprocessTextOfTheComparisonFile, hm.get(preIndexedFiles.get(i)).toString());
                    String match = sca.getList();
                    String firstFile = documentToCompare;
                    String secondFile =  preIndexedFiles.get(i);
                    System.out.println();
                    System.out.println(firstFile);
                    System.out.println(secondFile);
                    System.out.println("the string of the first text is" + preprocessTextOfTheComparisonFile);
                    System.out.println("the string of the second text is" + hm.get(preIndexedFiles.get(i)).toString());
                    System.out.println("match is "+ match);
                    System.out.println("Size of the matched files is "+fileNo);
                    System.out.println();
                    if(!match.isEmpty()){
                             //////////////// just for testing purposes
                    filenameText[fileNo][0] = firstFile;
                    filenameText[fileNo][1] = secondFile;
                    filenameText[fileNo][2] = match;
                    fileNo++;

                    String Isplagarised = null;
                    if (output > 1.5) {
                        Isplagarised = "1";
                    }
                    else {
                        Isplagarised = "0";
                    }
                   // filenameText[i][3] = Isplagarised;
                        }



        }



            return filenameText;
        }


    public String[][] compareAllFiles(HashMap<File, ArrayList<String>> indexedFilesList,HashMap<String, ArrayList<String>> downloadedFilesList) throws IOException{

        Iterator downloadIterator=downloadedFilesList.entrySet().iterator();
        Iterator it =  indexedFilesList.entrySet().iterator();
        ArrayList indexedFilesForFile=new  ArrayList();
        ArrayList downloadedFilesForFile=new  ArrayList();
        String[][] filenameText = new String[1000][4];
        int fileNo=0;
        int index=0;

        while (it.hasNext() ) {


            Map.Entry pair = (Map.Entry) it.next();
            File filePath = (File)pair.getKey();
            indexedFilesForFile=indexedFilesList.get(filePath);
            ShingleCloudAlgorithm sca = new ShingleCloudAlgorithm();

            for(int i=0;i< indexedFilesForFile.size();i++){
            File createFile=new File((String)indexedFilesForFile.get(i));
            float output = sca.getSimilarity(preprocessText(filePath.getAbsolutePath()), preprocessText(createFile.getAbsolutePath()));
                    String match = sca.getList();
                    String firstFile = filePath.getAbsolutePath();
                    String secondFile = createFile.getAbsolutePath();
                    System.out.println();
                    System.out.println(firstFile);
                    System.out.println(secondFile);
                    System.out.println("the string of the first text is " + preprocessText(filePath.getAbsolutePath()));
                    System.out.println("the string of the second text is " +preprocessText(createFile.getAbsolutePath()));
                    System.out.println("match is "+ match);
                    System.out.println("Size of the matched files is "+fileNo);
                    System.out.println();
                    if(!match.isEmpty()){
                             //////////////// just for testing purposes
                    filenameText[fileNo][0] = firstFile;
                    filenameText[fileNo][1] = secondFile;
                    filenameText[fileNo][2] = match;
                    fileNo++;

                    String Isplagarised = null;
                    if (output > 1.5) {
                        Isplagarised = "1";
                    }
                    else {
                        Isplagarised = "0";
                    }


        }







        }
        }

         while (downloadIterator.hasNext() ) {


            Map.Entry pair = (Map.Entry) downloadIterator.next();
            String filePath = (String)pair.getKey();
            downloadedFilesForFile=downloadedFilesList.get(filePath);
            ShingleCloudAlgorithm sca = new ShingleCloudAlgorithm();

            for(int i=0;i<  downloadedFilesForFile.size();i++){
            File createFile=new File((String)downloadedFilesForFile.get(i));
            float output = sca.getSimilarity(preprocessText(filePath), preprocessText(createFile.getAbsolutePath()));
                    String match = sca.getList();
                    String firstFile = filePath;
                    String secondFile = createFile.getAbsolutePath();
                    System.out.println();
                    System.out.println(firstFile);
                    System.out.println(secondFile);
                    System.out.println("the string of the first text is " + preprocessText(filePath));
                    System.out.println("the string of the second text is " +preprocessText(createFile.getAbsolutePath()));
                    System.out.println("match is "+ match);
                    System.out.println("Size of the matched files is "+fileNo);
                    System.out.println();
                    if(!match.isEmpty()){
                             //////////////// just for testing purposes
                    filenameText[fileNo][0] = firstFile;
                    filenameText[fileNo][1] = secondFile;
                    filenameText[fileNo][2] = match;
                    fileNo++;

                    String Isplagarised = null;
                    if (output > 1.5) {
                        Isplagarised = "1";
                    }
                    else {
                        Isplagarised = "0";
                    }


                    }







        }
        }









            return filenameText;
        }

    



    public String arraylistToSting(ArrayList<String> token) {
        StringBuilder out = new StringBuilder();
        for (Object o : token) {
            out.append(o.toString());
            out.append(" ");
        }
        return out.toString();
    }


    public File[] getFilesIntheFolder(String path){

        File dir = new File(path);
        File[] children = dir.listFiles();
        return children;

    }


    public String preprocessText(String filename,String fileFolder)throws IOException{
                String fullFilename = fileFolder + File.separator + filename;
                // document reading
                String documentText = docreader.processFileAndGetText(fullFilename);
                // removing numbers
                String numberRemoveText = documentText.replaceAll("[^a-zA-Z ]", "");
                //snawball analyser
                ArrayList<String> numberRemovedToken = null;
                ArrayList<String> stopWordRemovedTokens = null;
                numberRemovedToken = stopremover.analyze(numberRemoveText);
                String stopwordRemovedString = this.arraylistToSting(numberRemovedToken);
                stopWordRemovedTokens= stem.analyze(stopwordRemovedString);
                //String preprocessText = synReplaser.replaceSynonyms(tokens);
                String preprocessText = this.arraylistToSting(stopWordRemovedTokens);
                return preprocessText;
    }

    public String preprocessText(String filename)throws IOException{
                String fullFilename =  filename;
                // document reading
                String documentText = docreader.processFileAndGetText(fullFilename);
                // removing numbers
                String numberRemoveText = documentText.replaceAll("[^a-zA-Z ]", "");
                //snawball analyser
                ArrayList<String> numberRemovedToken = null;
                ArrayList<String> stopWordRemovedTokens = null;
                numberRemovedToken = stopremover.analyze(numberRemoveText);
                String stopwordRemovedString = this.arraylistToSting(numberRemovedToken);
                stopWordRemovedTokens= stem.analyze(stopwordRemovedString);
                //String preprocessText = synReplaser.replaceSynonyms(tokens);
                String preprocessText = this.arraylistToSting(stopWordRemovedTokens);
                return preprocessText;
    }

}

