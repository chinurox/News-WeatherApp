package in.pradumn.newsweather_1.responses;

import java.util.ArrayList;

/**
 * Created by Pradumn on 12-Oct-16.
 */
public class MashapeResponse {
    public ArrayList<MashapeNews> NewsItem;
    public ArrayList<MashapeNews> getNewsItem() {
        return NewsItem;
    }
    public void setNewsItem(ArrayList<MashapeNews> newsItem) {
        NewsItem = newsItem;
    }

    public static class MashapeNews{
        public String HeadLine;
        public String Story;
        public MashapePhoto Image;
        public String getHeadLine() {
            return HeadLine;
        }
        public void setHeadLine(String headLine) {
            HeadLine = headLine;
        }
        public MashapePhoto getImage() {
            return Image;
        }
        public void setImage(MashapePhoto image) {
            Image = image;
        }
        public String getStory() {
            return Story;
        }
        public void setStory(String story) {
            Story = story;
        }

        public static class MashapePhoto{
            public String Photo;
            public String getPhoto() {
                return Photo;
            }
            public void setPhoto(String photo) {
                Photo = photo;
            }
        }
    }
}
