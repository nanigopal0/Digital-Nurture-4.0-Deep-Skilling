import "./style.css"

export default function BlogDetails() {
  const blogs = [
    {
      id: 1,
      title: "React Learning",
      content: "Welcome to learning React!",
      author: "Stephan Biz",
    },
    {
      id: 2,
      title: "Installation",
      content: "You can install React from npm.",
      author: "Schewzdenier",
    },
  ];

  return (
    <div style={{height:"400px"}}>
      <h1>Blog Details</h1>
      {blogs.map((blog) => (
        <div key={blog.id}>
          <h2>{blog.title}</h2>
          <h4>{blog.author}</h4>
          <p>{blog.content}</p>
        </div>
      ))}
    </div>
  );
}
