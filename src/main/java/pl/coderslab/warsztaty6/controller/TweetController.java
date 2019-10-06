package pl.coderslab.warsztaty6.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.warsztaty6.entity.Comment;
import pl.coderslab.warsztaty6.entity.Tweet;
import pl.coderslab.warsztaty6.entity.User;
import pl.coderslab.warsztaty6.repository.CommentRepository;
import pl.coderslab.warsztaty6.repository.TweetRepository;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.time.LocalDateTime;

@Controller
@RequestMapping("/app/tweet")
public class TweetController {

    private TweetRepository tweetRepository;

    private CommentRepository commentRepository;

    @Autowired
    public TweetController(TweetRepository tweetRepository, CommentRepository commentRepository) {
        this.tweetRepository = tweetRepository;
        this.commentRepository = commentRepository;
    }

    @GetMapping("/{id}")
    public String getTweet(@PathVariable("id") Long id, Model model){
        Tweet tweet = tweetRepository.findOne(id);
        model.addAttribute("tweet", tweet);
        model.addAttribute("tweetComments", commentRepository.findCommentsByTweetIdOrderByCreatedDesc(id));
        model.addAttribute("comment", new Comment());
        return "tweet";
    }

    @PostMapping("/{id}")
    public String postTweet(@PathVariable("id") Long id,
                            @ModelAttribute("comment") @Valid Comment comment,
                            BindingResult result,
                            HttpSession session){
        if (result.hasErrors()){
            return "tweet";
        }
        else {
            Tweet tweet = tweetRepository.findOne(id);
            comment.setUser((User) session.getAttribute("appUser"));
            comment.setCreated(LocalDateTime.now());
            comment.setTweet(tweet);
            commentRepository.save(comment);
            return "redirect:/app/tweet/" + id;
        }
    }
}
