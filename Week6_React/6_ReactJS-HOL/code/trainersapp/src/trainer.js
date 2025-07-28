import React from "react";

class Trainer extends React.Component{
    constructor(trainerId,name,email,phone,technology,skills){
     super();
        this.trainerId = trainerId;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.technology = technology;
        this.skills = skills;
    }
}

export default Trainer;