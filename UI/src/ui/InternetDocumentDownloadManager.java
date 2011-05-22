/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ui;

import internetsearch.BingSearch;
import internetsearch.InternetSearchManager;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author nuwan
 */
public class InternetDocumentDownloadManager {

    String downloadFolderPath;
    HashMap<String, ArrayList<String>> downloadedFileList;
    ArrayList<String> fileArrayList;

    public String downloadFiles(String destFolderPath,String fName){

        System.out.println("Start Downloading the internet files........................");
        BingSearch bingSearch = new BingSearch("F138552F897E2CA7C264FDAC64F8EF2021ABD3AF");
        bingSearch.setMaxNumOfResults(10);
        InternetSearchManager sd = new InternetSearchManager(bingSearch);
        sd.setRandomSelectionRatio(0.2f);

        downloadFolderPath = sd.downloadSourcesForFile(destFolderPath + File.separator + fName);


        return downloadFolderPath ;
    }


    public HashMap<String, ArrayList<String>>  downloadFilesForMultiplePeerSearch(ArrayList<String> arr,String folderPath){

         fileArrayList=arr;
        String destFolderPath=folderPath;
        BingSearch bingSearch = new BingSearch("F138552F897E2CA7C264FDAC64F8EF2021ABD3AF");
        bingSearch.setMaxNumOfResults(10);
        InternetSearchManager sd = new InternetSearchManager(bingSearch);
        sd.setRandomSelectionRatio(0.2f);
        downloadedFileList = sd.downloadSourcesForFileFolder(fileArrayList, destFolderPath);

        return downloadedFileList;
    }

}
