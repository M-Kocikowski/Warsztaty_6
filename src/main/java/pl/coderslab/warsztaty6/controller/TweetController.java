package pl.coderslab.warsztaty6.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.warsztaty6.entity.Tweet;
import pl.coderslab.warsztaty6.repository.TweetRepository;

@Controller
@RequestMapping("/app/tweet")
public class TweetController {

    private TweetRepository tweetRepository;

    @Autowired
    public TweetController(TweetRepository tweetRepository) {
        this.tweetRepository = tweetRepository;
    }

    @GetMapping("/{id}")
    public String getTweet(@PathVariable("id") Long id, Model model){
        Tweet tweet = tweetRepository.findOne(id);
        model.addAttribute("tweet", tweet);
        return "tweet";
    }
}
