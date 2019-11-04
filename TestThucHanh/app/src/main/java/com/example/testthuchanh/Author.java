package com.example.testthuchanh;

public class Author {
    private int AuthorID;
    private String AuthorName;
    private String AuthorAddress;
    private String AuthorEmail;

    public Author(int authorID, String authorName, String authorAddress, String authorEmail) {
        AuthorID = authorID;
        AuthorName = authorName;
        AuthorAddress = authorAddress;
        AuthorEmail = authorEmail;
    }

    public Author() {
    }

    @Override
    public String toString() {
        return "Author{" +
                "AuthorID=" + AuthorID +
                ", AuthorName='" + AuthorName + '\'' +
                ", AuthorAddress='" + AuthorAddress + '\'' +
                ", AuthorEmail='" + AuthorEmail + '\'' +
                '}';
    }

    public int getAuthorID() {
        return AuthorID;
    }

    public void setAuthorID(int authorID) {
        AuthorID = authorID;
    }

    public String getAuthorName() {
        return AuthorName;
    }

    public void setAuthorName(String authorName) {
        AuthorName = authorName;
    }

    public String getAuthorAddress() {
        return AuthorAddress;
    }

    public void setAuthorAddress(String authorAddress) {
        AuthorAddress = authorAddress;
    }

    public String getAuthorEmail() {
        return AuthorEmail;
    }

    public void setAuthorEmail(String authorEmail) {
        AuthorEmail = authorEmail;
    }
}
