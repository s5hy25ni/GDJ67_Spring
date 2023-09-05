package com.min.edu.comm;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;

import com.google.cloud.vision.v1.*;
import com.google.protobuf.ByteString;

public class OCRDemo {
	
	  // 잘라낼 영역을 정의 (통일적인 내용)
    private static final Map<String, Rectangle> areas = new HashMap<>();
    
    static {
        areas.put("name", new Rectangle(714, 534, 466, 104));
        areas.put("contact", new Rectangle(1600, 534, 466, 104));
        areas.put("affiliation", new Rectangle(714, 654 ,466 ,104));
        areas.put("position", new Rectangle(1600 ,654 ,466 ,104));
        areas.put("period", new Rectangle(714 ,773 ,1462 ,117));
        areas.put("job_desc", new Rectangle(714 ,894 ,1462 ,117));
        areas.put("issuer_name", new Rectangle(714 ,1014 ,466 ,104));
        areas.put("issuer_contact", new Rectangle(1600, 1014, 466, 104));
        areas.put("create_date", new Rectangle(927 ,2419 ,639 ,82));
        areas.put("company_name", new Rectangle(576,2830,624,70));   
    }
    
    public static Map<String,Object> extractTextFromAreas(String fileName) throws IOException {
    	Map<String,Object> extractedTextMap = new HashMap<>();
    	
    	try (ImageAnnotatorClient client= ImageAnnotatorClient.create()) {
            for (Map.Entry<String,Rectangle> entry : areas.entrySet()) {
                String areaName = entry.getKey();
                Rectangle rect = entry.getValue();

                BufferedImage img = ImageIO.read(new File(fileName));

                // 이미지를 잘라냄
                BufferedImage croppedImg = img.getSubimage(rect.x,
                                                           rect.y,
                                                           rect.width,
                                                           rect.height);

                ByteString imgBytes = ByteString.copyFrom(toByteArray(croppedImg));

                List<AnnotateImageRequest> requests= new ArrayList<>();
                Image inputImage=Image.newBuilder().setContent(imgBytes).build();

                Feature desiredFeature=Feature.newBuilder().setType(
                		Feature.Type.DOCUMENT_TEXT_DETECTION).build();

                 AnnotateImageRequest request=AnnotateImageRequest.newBuilder()
                          .addFeatures(desiredFeature)
                          .setImage(inputImage)
                          .build();
                          
                   requests.add(request);

                   BatchAnnotateImagesResponse response=
                		   client.batchAnnotateImages(requests);
                   
                   List<AnnotateImageResponse> responses=response.getResponsesList();

                   for (AnnotateImageResponse res : responses) {
                       if (res.hasError()) {
                           System.out.printf(
                        		   "오류: %s%n",
                        		   res.getError().getMessage());
                           return extractedTextMap;  
                       }
                       String extractedText = res.getFullTextAnnotation().getText();
                       
                       extractedText = extractedText.replace("\n", " ");
                       
                       extractedTextMap.put(areaName, extractedText);
                   }
              }
              
              client.close();
              
           } catch (Exception e) {
               e.printStackTrace();
           }
    	
    	return extractedTextMap;
    }
    
    public static byte[] toByteArray(BufferedImage img) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(img, "png", baos);
        return baos.toByteArray();
    }
}
