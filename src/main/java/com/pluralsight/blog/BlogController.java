package com.pluralsight.blog;

import com.pluralsight.blog.data.PostRepository;
import com.pluralsight.blog.model.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class BlogController
{
    private PostRepository postRepository;
    public BlogController(PostRepository postRepository1)
    {
        this.postRepository=postRepository1;
    }
    @RequestMapping("/")
    public String listPosts(ModelMap mp)
    {
        List<Post> post = postRepository.getAllPosts();
        mp.put("posts",post);
        return "home";
    }

    @RequestMapping("/post/{id}")
    public String postDetails(@PathVariable Long id,ModelMap modelMap)
    {
        Post p=postRepository.findById(id);
        modelMap.put("post",p);
        return "post-details";
    }

}
