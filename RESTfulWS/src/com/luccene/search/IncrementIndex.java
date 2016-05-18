//package com.luccene.search;
//
//
//
//import java.io.BufferedReader;  
//import java.io.File;  
//import java.io.FileReader;  
//import java.io.FileWriter;  
//import java.io.IOException;  
//import java.io.PrintWriter;  
//import java.sql.Connection;  
//import java.sql.DriverManager;  
//import java.sql.ResultSet;  
//import java.sql.Statement;  
//import java.util.Date;  
//  
//import org.apache.lucene.analysis.Analyzer;  
//import org.apache.lucene.analysis.standard.StandardAnalyzer;  
//import org.apache.lucene.document.Document;  
//import org.apache.lucene.document.Field;  
//import org.apache.lucene.index.IndexWriter;
//import org.apache.lucene.index.IndexWriterConfig;
//import org.apache.lucene.store.Directory;
//import org.apache.lucene.store.FSDirectory;
//import org.apache.lucene.util.Version;  
//
//public class IncrementIndex {
//	
//	 public static void main(String[] args) {  
//	        try {  
//	            IncrementIndex index = new IncrementIndex();  
//	            String path = "E:\\workspace2\\Test\\lucene_test\\poiIdext";//索引文件的存放路径  
//	            String storeIdPath = "E:\\workspace2\\Test\\lucene_test\\storeId.txt";//存储ID的路径  
//	            String storeId = "";  
//	            Date date1 = new Date();  
//	            storeId = index.getStoreId(storeIdPath);  
//	            ResultSet rs = index.getResult(storeId);  
//	            System.out.println("开始建立索引。。。。");  
//	            index.indexBuilding(path, storeIdPath, rs);  
//	            Date date2 = new Date();  
//	            System.out.println("耗时："+(date2.getTime()-date1.getTime())+"ms");  
//	            storeId = index.getStoreId(storeIdPath);  
//	            System.out.println(storeId);//打印出这次存储起来的ID  
//	        } catch (Exception e) {  
//	            e.printStackTrace();  
//	        }  
//	    }  
//	  
//	    public static void buildIndex(String indexFile, String storeIdFile) {  
//	        try {  
//	            String path = indexFile;//索引文件的存放路径  
//	            String storeIdPath = storeIdFile;//存储ID的路径  
//	            String storeId = "";  
//	            storeId = getStoreId(storeIdPath);  
//	            ResultSet rs = getResult(storeId);  
//	            indexBuilding(path, storeIdPath, rs);  
//	            storeId = getStoreId(storeIdPath);  
//	            System.out.println(storeId);//打印出这次存储起来的ID  
//	        } catch (Exception e) {  
//	            e.printStackTrace();  
//	        }  
//	    }  
//	  
//	    public static ResultSet getResult(String storeId) throws Exception {  
//	        Class.forName("com.mysql.jdbc.Driver").newInstance();  
//	        String url = "jdbc:mysql://localhost:3306/lucenetest";  
//	        String userName = "root";  
//	        String password = "****";  
//	        Connection conn = DriverManager.getConnection(url, userName, password);  
//	        Statement stmt = conn.createStatement();  
//	        String sql = "select  * from pd_ugc";  
//	        ResultSet rs = stmt.executeQuery(sql + " where id > '" + storeId + "'order by id");  
//	        return rs;  
//	    }  
//	  
//	    public static boolean indexBuilding(String path, String storeIdPath, ResultSet rs) {  
//	        try {  
//	            Analyzer luceneAnalyzer = new StandardAnalyzer();  
//	            // 取得存储起来的ID，以判定是增量索引还是重新索引  
//	            boolean isEmpty = true;  
//	            try {  
//	                File file = new File(storeIdPath);  
//	                if (!file.exists()) {  
//	                    file.createNewFile();  
//	                }  
//	                FileReader fr = new FileReader(storeIdPath);  
//	                BufferedReader br = new BufferedReader(fr);  
//	                if (br.readLine() != null) {  
//	                    isEmpty = false;  
//	                }  
//	                br.close();  
//	                fr.close();  
//	            } catch (IOException e) {  
//	                e.printStackTrace();  
//	            }  
//	            Directory dir=FSDirectory.open(new File(path));
//	            IndexWriterConfig indexWriterConfig=new IndexWriterConfig(Version.LUCENE_4_10_4, luceneAnalyzer);
//	            //isEmpty=false表示增量索引  
//	            IndexWriter writer = new IndexWriter(dir,indexWriterConfig);  
//	            String storeId = "";  
//	            boolean indexFlag = false;  
//	            String id;  
//	            String name;  
//	            String address;  
//	            String citycode;  
//	            while (rs.next()) {  
//	                id = rs.getInt("id") + "";  
//	                name = rs.getString("name");  
//	                address = rs.getString("address");  
//	                citycode = rs.getString("citycode");  
//	                writer.addDocument(Document(id, name, address, citycode));  
//	                storeId = id;//将拿到的id给storeId，这种拿法不合理，这里为了方便  
//	                indexFlag = true;  
//	            }  
//	            writer.optimize();  
//	            writer.close();  
//	            if (indexFlag) {  
//	                // 将最后一个的ID存到磁盘文件中  
//	                writeStoreId(storeIdPath, storeId);  
//	            }  
//	            return true;  
//	        } catch (Exception e) {  
//	            e.printStackTrace();  
//	            System.out.println("出错了" + e.getClass() + "\n   错误信息为:   " + e.getMessage());  
//	            return false;  
//	        }  
//	  
//	    }  
//	  
//	    public static Document Document(String id, String name, String address, String citycode) {  
//	        Document doc = new Document();  
//	        doc.add(new Field("id", id, Field.Store.YES, Field.Index.TOKENIZED));  
//	        doc.add(new Field("name", name, Field.Store.YES, Field.Index.TOKENIZED));//查询字段  
//	        doc.add(new Field("address", address, Field.Store.YES, Field.Index.TOKENIZED));  
//	        doc.add(new Field("citycode", citycode, Field.Store.YES, Field.Index.TOKENIZED));//查询字段  
//	        return doc;  
//	    }  
//	  
//	    // 取得存储在磁盘中的ID  
//	    public static String getStoreId(String path) {  
//	        String storeId = "";  
//	        try {  
//	            File file = new File(path);  
//	            if (!file.exists()) {  
//	                file.createNewFile();  
//	            }  
//	            FileReader fr = new FileReader(path);  
//	            BufferedReader br = new BufferedReader(fr);  
//	            storeId = br.readLine();  
//	            if (storeId == null || storeId == "") storeId = "0";  
//	            br.close();  
//	            fr.close();  
//	        } catch (Exception e) {  
//	            e.printStackTrace();  
//	        }  
//	        return storeId;  
//	    }  
//	  
//	    // 将ID写入到磁盘文件中  
//	    public static boolean writeStoreId(String path, String storeId) {  
//	        boolean b = false;  
//	        try {  
//	            File file = new File(path);  
//	            if (!file.exists()) {  
//	                file.createNewFile();  
//	            }  
//	            FileWriter fw = new FileWriter(path);  
//	            PrintWriter out = new PrintWriter(fw);  
//	            out.write(storeId);  
//	            out.close();  
//	            fw.close();  
//	            b = true;  
//	        } catch (IOException e) {  
//	            e.printStackTrace();  
//	        }  
//	        return b;  
//	    }  
//}
