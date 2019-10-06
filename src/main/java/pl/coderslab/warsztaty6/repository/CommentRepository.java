package pl.coderslab.warsztaty6.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.warsztaty6.entity.Comment;
import pl.coderslab.warsztaty6.entity.Tweet;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    List<Comment> findCommentsByTweetOrderByCreatedDesc(Tweet tweet);

    List<Comment> findCommentsByTweetIdOrderByCreatedDesc(Long tweetId);

}
