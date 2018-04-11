package com.example.a10062376.helloweather.mvp.model;

import java.util.List;

/**
 * Created by 10062376 on 2018/1/24.
 */

public class MovieEntity {

    /**
     * count : 10
     * start : 0
     * subjects : [{"alt":"https://movie.douban.com/subject/1292052/","casts":[{"alt":"https://movie.douban.com/celebrity/1054521/","avatars":{"large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p17525.webp","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p17525.webp","small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p17525.webp"},"id":"1054521","name":"蒂姆·罗宾斯"}]
     * title : 豆瓣电影Top250
     * total : 250
     */

    private int count;
    private int start;
    private String title;
    private int total;
    private List<SubjectsBean> subjects;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<SubjectsBean> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<SubjectsBean> subjects) {
        this.subjects = subjects;
    }

    public static class SubjectsBean {
        /**
         * alt : https://movie.douban.com/subject/1292052/
         * casts : [{"alt":"https://movie.douban.com/celebrity/1054521/","avatars":{"large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p17525.webp","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p17525.webp","small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p17525.webp"},"id":"1054521","name":"蒂姆·罗宾斯"}]
         * collect_count : 1203461
         * directors : [{"alt":"https://movie.douban.com/celebrity/1047973/","avatars":{"large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p230.webp","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p230.webp","small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p230.webp"},"id":"1047973","name":"弗兰克·德拉邦特"}]
         * genres : ["犯罪","剧情"]
         * id : 1292052
         * images : {"large":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p480747492.webp","medium":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p480747492.webp","small":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p480747492.webp"}
         * original_title : The Shawshank Redemption
         * rating : {"average":9.6,"max":10,"min":0,"stars":"50"}
         * subtype : movie
         * title : 肖申克的救赎
         * year : 1994
         */

        private String alt;
        private int collect_count;
        private String id;
        private ImagesBean images;
        private String original_title;
        private RatingBean rating;
        private String subtype;
        private String title;
        private String year;
        private List<CastsBean> casts;
        private List<DirectorsBean> directors;
        private List<String> genres;

        public String getAlt() {
            return alt;
        }

        public void setAlt(String alt) {
            this.alt = alt;
        }

        public int getCollect_count() {
            return collect_count;
        }

        public void setCollect_count(int collect_count) {
            this.collect_count = collect_count;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public ImagesBean getImages() {
            return images;
        }

        public void setImages(ImagesBean images) {
            this.images = images;
        }

        public String getOriginal_title() {
            return original_title;
        }

        public void setOriginal_title(String original_title) {
            this.original_title = original_title;
        }

        public RatingBean getRating() {
            return rating;
        }

        public void setRating(RatingBean rating) {
            this.rating = rating;
        }

        public String getSubtype() {
            return subtype;
        }

        public void setSubtype(String subtype) {
            this.subtype = subtype;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getYear() {
            return year;
        }

        public void setYear(String year) {
            this.year = year;
        }

        public List<CastsBean> getCasts() {
            return casts;
        }

        public void setCasts(List<CastsBean> casts) {
            this.casts = casts;
        }

        public List<DirectorsBean> getDirectors() {
            return directors;
        }

        public void setDirectors(List<DirectorsBean> directors) {
            this.directors = directors;
        }

        public List<String> getGenres() {
            return genres;
        }

        public void setGenres(List<String> genres) {
            this.genres = genres;
        }

        public static class ImagesBean {
            /**
             * large : https://img3.doubanio.com/view/photo/s_ratio_poster/public/p480747492.webp
             * medium : https://img3.doubanio.com/view/photo/s_ratio_poster/public/p480747492.webp
             * small : https://img3.doubanio.com/view/photo/s_ratio_poster/public/p480747492.webp
             */

            private String large;
            private String medium;
            private String small;

            public String getLarge() {
                return large;
            }

            public void setLarge(String large) {
                this.large = large;
            }

            public String getMedium() {
                return medium;
            }

            public void setMedium(String medium) {
                this.medium = medium;
            }

            public String getSmall() {
                return small;
            }

            public void setSmall(String small) {
                this.small = small;
            }
        }

        public static class RatingBean {
            /**
             * average : 9.6
             * max : 10
             * min : 0
             * stars : 50
             */

            private double average;
            private int max;
            private int min;
            private String stars;

            public double getAverage() {
                return average;
            }

            public void setAverage(double average) {
                this.average = average;
            }

            public int getMax() {
                return max;
            }

            public void setMax(int max) {
                this.max = max;
            }

            public int getMin() {
                return min;
            }

            public void setMin(int min) {
                this.min = min;
            }

            public String getStars() {
                return stars;
            }

            public void setStars(String stars) {
                this.stars = stars;
            }
        }

        public static class CastsBean {
            /**
             * alt : https://movie.douban.com/celebrity/1054521/
             * avatars : {"large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p17525.webp","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p17525.webp","small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p17525.webp"}
             * id : 1054521
             * name : 蒂姆·罗宾斯
             */

            private String alt;
            private AvatarsBean avatars;
            private String id;
            private String name;

            public String getAlt() {
                return alt;
            }

            public void setAlt(String alt) {
                this.alt = alt;
            }

            public AvatarsBean getAvatars() {
                return avatars;
            }

            public void setAvatars(AvatarsBean avatars) {
                this.avatars = avatars;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public static class AvatarsBean {
                /**
                 * large : https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p17525.webp
                 * medium : https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p17525.webp
                 * small : https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p17525.webp
                 */

                private String large;
                private String medium;
                private String small;

                public String getLarge() {
                    return large;
                }

                public void setLarge(String large) {
                    this.large = large;
                }

                public String getMedium() {
                    return medium;
                }

                public void setMedium(String medium) {
                    this.medium = medium;
                }

                public String getSmall() {
                    return small;
                }

                public void setSmall(String small) {
                    this.small = small;
                }
            }
        }

        public static class DirectorsBean {
            /**
             * alt : https://movie.douban.com/celebrity/1047973/
             * avatars : {"large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p230.webp","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p230.webp","small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p230.webp"}
             * id : 1047973
             * name : 弗兰克·德拉邦特
             */

            private String alt;
            private AvatarsBeanX avatars;
            private String id;
            private String name;

            public String getAlt() {
                return alt;
            }

            public void setAlt(String alt) {
                this.alt = alt;
            }

            public AvatarsBeanX getAvatars() {
                return avatars;
            }

            public void setAvatars(AvatarsBeanX avatars) {
                this.avatars = avatars;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public static class AvatarsBeanX {
                /**
                 * large : https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p230.webp
                 * medium : https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p230.webp
                 * small : https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p230.webp
                 */

                private String large;
                private String medium;
                private String small;

                public String getLarge() {
                    return large;
                }

                public void setLarge(String large) {
                    this.large = large;
                }

                public String getMedium() {
                    return medium;
                }

                public void setMedium(String medium) {
                    this.medium = medium;
                }

                public String getSmall() {
                    return small;
                }

                public void setSmall(String small) {
                    this.small = small;
                }
            }
        }
    }
}
