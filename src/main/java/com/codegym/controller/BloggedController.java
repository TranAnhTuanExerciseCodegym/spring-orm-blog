package com.codegym.controller;


import com.codegym.model.Blogged;
import com.codegym.service.BloggedService;
import org.hibernate.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class BloggedController {
    @Autowired
    private BloggedService bloggedService;

    @GetMapping("/create-blog")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/blog/create");
        modelAndView.addObject("blog", new Blogged());
        return modelAndView;
    }

    @PostMapping("/blog-create")
    public String saveBlog(
            @ModelAttribute("blog") Blogged blogged,
            RedirectAttributes redirectAttributes
    ) {
        bloggedService.save(blogged);
        redirectAttributes.addFlashAttribute("message", "New create blog successfully");
        return "redirect:/";
    }

    @GetMapping("/")
    public ModelAndView listBlog() {
        ModelAndView modelAndView = new ModelAndView("/blog/list");
        modelAndView.addObject("blog", bloggedService.findAll());
        return modelAndView;
    }

    @GetMapping("/blog/{id}/edit")
    public ModelAndView showEditBlog(
            @PathVariable("id") Integer id
    ) {
        Blogged blog = bloggedService.findById(id);
        if (blog != null) {
            ModelAndView modelAndView = new ModelAndView("/blog/edit");
            modelAndView.addObject("blog", blog);
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("/blog/error");
            return modelAndView;
        }
    }

    @PostMapping("/blog-save")
    public String updateBlog(
            @ModelAttribute("blog") Blogged blogged,
            RedirectAttributes redirectAttributes
    ) {
        bloggedService.save(blogged);
//        ModelAndView modelAndView = new ModelAndView();
        redirectAttributes.addFlashAttribute("message", "Blog updated successfully");
        return "redirect:/";
    }

    @GetMapping("/blog/{id}/delete")
    public ModelAndView deleteBlog(
            @PathVariable("id") Integer id
    ) {
        Blogged blogged = bloggedService.findById(id);
        if (blogged != null) {
            ModelAndView modelAndView = new ModelAndView("/blog/delete");
            modelAndView.addObject("blog", blogged);
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("/blog/error");
            return modelAndView;
        }
    }

    @PostMapping("/blog-remove")
    public String removeBlog(
            @ModelAttribute("blog") Blogged blogged,
            RedirectAttributes redirectAttributes
    ) {
        bloggedService.remove(blogged.getId());
        redirectAttributes.addFlashAttribute("message", "Blog remove successfully");
        return "redirect:/";
    }

    @GetMapping("/blog/{id}/view")
    public ModelAndView viewBlog(
            @PathVariable("id") Integer id
    ) {
        Blogged blogged = bloggedService.findById(id);
        if (blogged != null) {
            ModelAndView modelAndView = new ModelAndView("/blog/view");
            modelAndView.addObject("blog", blogged);
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("/blog/error");
            return modelAndView;
        }

    }
}
