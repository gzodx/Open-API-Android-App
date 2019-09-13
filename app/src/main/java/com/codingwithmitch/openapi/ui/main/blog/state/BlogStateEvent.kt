package com.codingwithmitch.openapi.ui.main.blog.state



sealed class BlogStateEvent{

    class BlogSearchEvent: BlogStateEvent()

    class NextPageEvent: BlogStateEvent()

    class CheckAuthorOfBlogPost: BlogStateEvent()

    class None: BlogStateEvent()


}