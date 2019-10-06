package pl.coderslab.warsztaty6.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.coderslab.warsztaty6.entity.Tweet;
import pl.coderslab.warsztaty6.entity.User;

import java.util.List;

public interface TweetRepository extends JpaRepository<Tweet, Long> {

    List<Tweet> findTweetsByUser(User user);

    @Query("select t from Tweet t where t.user = ?1 order by t.created desc")
    List<Tweet> findTweetsByUserIdOrderByCreatedDesc(User user);

    List<Tweet> findTweetsByOrderByCreatedDesc();

}
