package org.nlms.commons.util;

/**
 * FileName: PTestFileUtils.java
 *
 * @author PK185013
 * The class generates JUnit Test class which contains TestCases.
 * The TestCases are generated based on the XML input file.
 *
 */

// Import Statements
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

// TestClassGenerator class
public class FileNDirUtils
{
    public static List<String> getFileNamesList(String baseDir, String endsWith)
    {
        List<String> fileList = null;
        try
        {
            fileList = getFileNamesList(baseDir, "", endsWith);
        }
        catch (Exception e)
        {

        }

        return fileList;
    }

    public static List<String> getFileNamesList(String baseDir, String srcDir, String endsWith)
            throws Exception
    {
        File objFile = new File(baseDir + "/" + srcDir);
        String contents[] = objFile.list();
        List<String> fileList = new ArrayList<String>();

        for (int i = 0; i < contents.length; i++)
        {
            String tempFileName = srcDir + "/" + contents[i];
            if ((srcDir != null) && (srcDir.equals("")))
            {
                tempFileName = contents[i];
            }

            File objTempFile = new File(baseDir + "/" + tempFileName);
            if (objTempFile.isDirectory())
            {
                List<String> tempFileList = getFileNamesList(baseDir, tempFileName, endsWith);
                for (int j = 0; j < tempFileList.size(); j++)
                {
                    fileList.add((String) tempFileList.get(j));
                }
            }
            else
            {
                if (tempFileName.endsWith(endsWith))
                {
                    fileList.add(tempFileName);
                }
            }
        }

        return fileList;
    }

    public static void deleteFile(String fileName)
    {
        File objFile = new File(fileName);
        if (objFile.isDirectory())
        {
            File objContents[] = objFile.listFiles();
            for (int i = 0; i < objContents.length; i++)
            {
                deleteFile(objContents[i].toString());
            }
        }
        objFile.delete();
    }

    public static String getFileString(String fileName)
    {
        if (!(new File(fileName)).exists())
            return null;

        try
        {
            StringBuffer objFileBuffer = new StringBuffer();
            FileInputStream objFileInputStream = new FileInputStream(new File(fileName));
            byte bytBuffer[] = new byte[1024];
            int size = objFileInputStream.read(bytBuffer);
            while (size != -1)
            {
                objFileBuffer.append(new String(bytBuffer, 0, size));
                size = objFileInputStream.read(bytBuffer);
            }
            objFileInputStream.close();

            return objFileBuffer.toString();
        }
        catch (IOException e)
        {
            System.out.println("ERROR: " + e);
        }
        return null;
    }

    public static List<String> getFileContentLines(String fileName)
    {
        List<String> codeLines = new ArrayList<String>();

        try
        {
            DataInputStream din = new DataInputStream(new FileInputStream(new File(fileName)));
            String str = din.readLine();
            while (str != null)
            {
                codeLines.add(str);
                str = din.readLine();
            }
            din.close();
        }
        catch (Exception e)
        {
            System.out.println("Error: " + e.getMessage());
        }

        return codeLines;
    }

    public static List<String> getDirNamesList(String baseDir) throws Exception
    {
        List<String> fileList = getDirNamesList(baseDir, "");
        return fileList;
    }

    public static List<String> getDirNamesList(String baseDir, String srcDir) throws Exception
    {
        File objFile = new File(baseDir + "/" + srcDir);
        String contents[] = objFile.list();
        List<String> fileList = new ArrayList<String>();

        for (int i = 0; i < contents.length; i++)
        {
            String tempFileName = srcDir + "/" + contents[i];
            if (srcDir == "")
                tempFileName = contents[i];
            File objTempFile = new File(baseDir + "/" + tempFileName);
            if (objTempFile.isDirectory())
            {
                List<String> tempFileList = getDirNamesList(baseDir, tempFileName);
                for (int j = 0; j < tempFileList.size(); j++)
                {
                    fileList.add((String) tempFileList.get(j));
                }
                fileList.add(tempFileName);
            }
        }

        return fileList;
    }

    public static void createDirs(String baseDir, List<String> dirList)
    {
        try
        {
            for (int i = 0; i < dirList.size(); i++)
            {
                String fileName = baseDir + "/" + dirList.get(i);
                File objFile = new File(fileName);
                objFile.mkdirs();
            }
        }
        catch (Exception e)
        {
            System.out.println("ERROR: " + e);
        }
    }

    // Loads the ".properties" file and returns the Properties object
    public static Properties loadProperties(String fileName)
    {
        Properties props = null;
        try
        {
            props = new Properties();
            props.load(new FileInputStream(fileName));
        }
        catch (Exception e)
        {
            System.out.println("ERROR : " + e);
        }

        return props;
    }

    public static void writeToFile(String str, String fileName)
    {
        try
        {
            FileOutputStream fout = new FileOutputStream(new File(fileName));
            fout.write(str.getBytes());
            fout.close();
        }
        catch (Exception e)
        {
            System.out.println("ERROR : " + e);
        }
    }

    public static void writeToFile(byte[] bytes, String fileName)
    {
        try
        {
            FileOutputStream fout = new FileOutputStream(new File(fileName));
            fout.write(bytes);
            fout.close();
        }
        catch (Exception e)
        {
            System.out.println("ERROR : " + e);
        }
    }

    public static boolean isFileExists(String fileName)
    {
        boolean exists = (new File(fileName)).exists();
        if (exists)
            return true;
        else
            return false;
    }
}