import { Component } from "react";

export default class Posts extends Component {
  constructor(props) {
    super(props);
  }

  loadPosts() {
    fetch("https://jsonplaceholder.typicode.com/posts", {
      method: "GET",
      headers: {
        "Content-Type": "application/json",
      },
    })
      .then((response) => response.json())
      .then((data) => {
        this.setState({ posts: data });
      })
      .catch((error) => {
        console.error("Fetch error:", error);
      });
  }

  componentDidMount() {
    this.loadPosts();
  }

  componentDidCatch(error, info) {
    console.error("Error loading posts:", error, info);
    alert("Error loading posts. " + info);
  }

  render() {
    return (
      <div>
        {this.state &&
          this.state.posts.map((post) => {
            return (
              <div key={post.id}>
                <h1>{post.title}</h1>
                <p>{post.body}</p>
              </div>
            );
          })}
      </div>
    );
  }
}
