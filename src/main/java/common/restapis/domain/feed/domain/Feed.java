package common.restapis.domain.feed.domain;

import common.restapis.domain.feed.Category;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Feed {

    private Long id;
    private String feedTitle;
    private String feedWriter;
    private Category category;
    private List<String> feedContents;

    public Feed(String feedTitle, String feedWriter, Category category, List<String> feedContents) {
        this.feedTitle = feedTitle;
        this.feedWriter = feedWriter;
        this.category = category;
        this.feedContents = feedContents;
    }
}
