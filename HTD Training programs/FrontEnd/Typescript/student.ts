class Student1 {
    constructor(
        public name: string,
        public age: number,
        public USN: string,
        public marks: number,
        public aadharNo?: number,
        public panCard?:string
    ){

    }
}
let student3=new Student1('name',21,'abc123',80,undefined,'ghf567');
let student2:Student1={
    name: 'pranitha',
    age:20,
    USN: 'dfgh56',
    marks: 69
}
let clearedStudents=[
    new Student1('manju',21,'15ka1a0518',78,989122776321,'Py632')
];
