package com.feng.entities.representation;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class BookDetails {

    private String bookId;
    private String name;
    private LocalDate publishDay;

//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createAt;
    private List<Chapter> chapters;

    @Data
    public class Chapter {
        private String name;
        private String summary;
        private Integer index;
    }

}
