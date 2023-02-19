package com.driver.services;

import com.driver.models.*;
import com.driver.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ImageService {

    @Autowired
    BlogRepository blogRepository2;
    @Autowired
    ImageRepository imageRepository2;

    public Image addImage(Integer blogId, String description, String dimensions){
        //add an image to the blog
        Image image=new Image();
        image.setDescription(description);
        image.setDimensions(dimensions);

        Blog blog=blogRepository2.findById(blogId).get();
        image.setBlog(blog);
        List<Image> imageList=new ArrayList<>();
        imageList.add(image);
        blog.setImageList(imageList);


        blogRepository2.save(blog);

         return image;

    }

    public void deleteImage(Integer id){
        imageRepository2.deleteById(id);

    }

    public int countImagesInScreen(Integer id, String screenDimensions) {
        //Find the number of images of given dimensions that can fit in a screen having `screenDimensions`
        int count=0;

        Image image=imageRepository2.findById(id).get();

        String dimensions=image.getDimensions();

        String dim[]=dimensions.split("X");
        int imageLength=Integer.parseInt(dim[0]);
        int imageBreadth=Integer.parseInt(dim[1]);


        String screendim[]=screenDimensions.split("X");
        int screenlength=Integer.parseInt(screendim[0]);
        int screenBreadth=Integer.parseInt(screendim[1]);


        count=((screenlength/imageLength)*(screenBreadth/imageBreadth));
        return count;


    }
}
