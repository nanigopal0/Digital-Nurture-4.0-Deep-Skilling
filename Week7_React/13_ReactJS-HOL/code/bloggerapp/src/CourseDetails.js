import "./style.css"

export default function CourseDetails() {
  const courses = [
    { id: 10, name: "Angular", date: "04/05/2021" },
    { id: 11, name: "React", date: "06/03/2022" },
  ];

  return (
    <div className="itemRightBorder">
      <h1>Course Details</h1>

      {courses.map((course) => (
        <div key={course.id}>
          <h3>{course.name}</h3>
          <h4>{course.date}</h4>
        </div>
      ))}
    </div>
  );
}
