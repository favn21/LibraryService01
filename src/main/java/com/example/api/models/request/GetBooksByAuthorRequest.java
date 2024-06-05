package com.example.api.models.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.Getter;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
@XmlRootElement(name = "GetBooksByAuthorRequest")
public class GetBooksByAuthorRequest {
    @XmlElement(name = "authorId")
    private Long authorId;

    public GetBooksByAuthorRequest(Long authorId) {
        this.authorId = authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

}
