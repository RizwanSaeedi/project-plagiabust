/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package internetsearch;

import querycreator.QueryCreator;
import querycreator.QuerySelectionAlgorithm;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.htmlparser.beans.StringBean;

/**
 *
 * @author Brave Heart
 */
public class InternetSearchManager {

    private QuerySelectionAlgorithm qsa = QuerySelectionAlgorithm.Random;
    private QueryCreator qc = new QueryCreator();
    private final BingSearch bingSearch;
    private int maxNumOfSourcesPerDocument = 10;

    public InternetSearchManager(BingSearch bingSearch) {
        this.bingSearch = bingSearch;
    }

    public void setQuerySelectionAlgorithm(QuerySelectionAlgorithm selectionAlgo) {
        qsa = selectionAlgo;
    }

    public QuerySelectionAlgorithm getQuerySelectionAlgorithm() {
        return qsa;
    }

    public String downloadSourcesForFile(String filePath) {
        File file = new File(filePath);
        String[] nameAndExt = file.getName().split("[.]");
        String downloadedFilesFolder = file.getParent() + File.separator + nameAndExt[0];
        File fi= new File(downloadedFilesFolder);
        if (!(fi.exists())){
        boolean folderExist = new File(downloadedFilesFolder).mkdir();
            HashMap<String, Integer> selectedSources = new HashMap<String, Integer>();
        // Get list of sources
            selectedSources = this.getInternetSourceForFile(filePath);
        // Create directory
        // Downloading page
            int downloadedDocuments = 1;
            Iterator it = selectedSources.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry pair = (Map.Entry) it.next();
                String url = (String) pair.getKey();
                System.out.println(url);
                String path = downloadedFilesFolder + File.separatorChar + downloadedDocuments + ".txt";
                downloadedDocuments++;
                this.downloadWebPageAsText(url, path);
            }

        }
        return downloadedFilesFolder;
    }

    /*
    public String downloadSourcesForFile(String filePath) {         // firstcall

     HashMap<String, Integer> selectedSources = new HashMap<String, Integer>();
    // Get list of sources
    selectedSources = this.getInternetSourceForFile(filePath);   //call
    // Create directory
    File file = new File(filePath);
    String[] nameAndExt = file.getName().split("[.]");
    String downloadedFilesFolder = file.getParent() + File.separator + nameAndExt[0];
    boolean folderCreated = new File(downloadedFilesFolder).mkdir();
    // Downloading page
    int downloadedDocuments = 1;
    //parellel code
    /*    long t1 = System.currentTimeMillis();
    Runnable runnable = new DownloadWebPage(selectedSources ,downloadedFilesFolder);
    ExecutorService pool = Executors.newFixedThreadPool(3);
    // run the task 5 times using the pool
    for (int i = 0; i < 5; i++) {
    pool.execute(runnable);
    }
    pool.shutdown();
    while(!pool.isTerminated()){};
    long t2 = System.currentTimeMillis();
    System.out.print((t2-t1)/1000);*/

    //remove to check for parellel

    /*        long t1 = System.currentTimeMillis();
    Iterator it = selectedSources.entrySet().iterator();
    while (it.hasNext()) {
    Map.Entry pair = (Map.Entry) it.next();
    String url = (String) pair.getKey();
    String path = downloadedFilesFolder + File.separatorChar + downloadedDocuments + ".txt";
    downloadedDocuments++;
    this.downloadWebPageAsText(url, path);   // secondcall
    }
    long t2 = System.currentTimeMillis();
    System.out.print((t2-t1)/1000);
    return downloadedFilesFolder;
    }*/
    public HashMap<String, ArrayList<String>> downloadSourcesForFileFolder(ArrayList<String> filePathList, String fileFolderPath) {
        // file name maps to list of downloaded sources
        HashMap<String, ArrayList<String>> fileAndSorcesMap = new HashMap<String, ArrayList<String>>();
        HashMap<String, String> urlAndDownloadedPathMap = new HashMap<String, String>();
        // Search for each file and sort
        int downloadedFileIndex = 0;
        String downloadedFileFolderPath = fileFolderPath + File.separator + "InternetSources";
        boolean folderCreated = new File(downloadedFileFolderPath).mkdir();
        for (Iterator<String> it = filePathList.iterator(); it.hasNext();) {
            String filePath = it.next();
            // take sources for file
            HashMap<String, Integer> sourcesOfFile = this.getInternetSourceForFile(filePath);
            ArrayList<String> downloadedFilesList = new ArrayList<String>();
            // download file
            Iterator sourceIterator = sourcesOfFile.entrySet().iterator();
            while (sourceIterator.hasNext()) {
                Map.Entry pair = (Map.Entry) sourceIterator.next();
                String url = (String) pair.getKey();
                if (urlAndDownloadedPathMap.get(url) == null) {
                    // mark new file and download
                    downloadedFileIndex++;
                    String filePathToDownload = downloadedFileFolderPath + File.separator + downloadedFileIndex + ".txt";
                    urlAndDownloadedPathMap.put(url, filePathToDownload);
                    this.downloadWebPageAsText(url, filePathToDownload);
                    downloadedFilesList.add(filePathToDownload);
                } else {
                    String fileDownloadedPath = urlAndDownloadedPathMap.get(url);
                    downloadedFilesList.add(fileDownloadedPath);
                }
            }
            fileAndSorcesMap.put(filePath, downloadedFilesList);
        }
        return fileAndSorcesMap;
    }








    
    private HashMap<String, Integer> getInternetSourceForFile(String filePath) {

        ArrayList<String> queryList = qc.getQueryList(filePath, qsa);
        HashMap<String, Integer> sources = new HashMap<String, Integer>();
        HashMap<String, Integer> selectedSources = new HashMap<String, Integer>();

        for (Iterator<String> it = queryList.iterator(); it.hasNext();) {
            String query = it.next();
            ArrayList<ResponseResult> response = bingSearch.searchInternet(query);
            if (!response.isEmpty()) {
                for (Iterator<ResponseResult> it1 = response.iterator(); it1.hasNext();) {
                    ResponseResult responseResult = it1.next();
                    // if url already exist
                    if (sources.get(responseResult.getUrl()) != null) {
                        String result = responseResult.getUrl();
                        int num = sources.get(result) + 1;
                        sources.put(result, num);
                    } // if url doesnt exist in hashmap
                    else {
                        sources.put(responseResult.getUrl(), 1);
                    }
                }
            }
        }

        // Sorting hashmap
        HashMap<String, Integer> sortedSources = (HashMap<String, Integer>) this.sortByValue(sources);
        Iterator sortedSourceIterator = sortedSources.entrySet().iterator();
        int numberOfSelectedDoc = 1;
        while (sortedSourceIterator.hasNext() && numberOfSelectedDoc <= 10) {
            Map.Entry pair = (Map.Entry) sortedSourceIterator.next();
            String key = (String) pair.getKey();
            int value = (Integer) pair.getValue();

            selectedSources.put(key, value);
            numberOfSelectedDoc++;
        }
        return selectedSources;
    }

    private Map sortByValue(Map map) {
        List list = new LinkedList(map.entrySet());
        Collections.sort(list, new Comparator() {

            public int compare(Object o1, Object o2) {
                return ((Comparable) ((Map.Entry) (o2)).getValue()).compareTo(((Map.Entry) (o1)).getValue());
            }
        });

        Map result = new LinkedHashMap();
        for (Iterator it = list.iterator(); it.hasNext();) {
            Map.Entry entry = (Map.Entry) it.next();
            result.put(entry.getKey(), entry.getValue());
        }
        return result;
    }

    private void downloadWebPageAsText(String url, String fileName) {
        String content = "";
        StringBean stringBean = new StringBean();
        stringBean.setURL(url);
        content = stringBean.getStrings();

        File file = new File(fileName);
        try {
            file.createNewFile();
            if (file.exists()) {
                FileWriter fw = new FileWriter(file, false);
                fw.write(content);
                fw.close();
            }
        } catch (IOException ex) {
        }

    }

    public void setRandomSelectionRatio(float ratio) {
        qc.setRandomSelectionRatio(ratio);
    }

    public int getMaxNumOfSourcesPerDocument() {
        return maxNumOfSourcesPerDocument;
    }

    public void setMaxNumOfSourcesPerDocument(int maxNumOfSourcesPerDocument) {
        this.maxNumOfSourcesPerDocument = maxNumOfSourcesPerDocument;
    }
}