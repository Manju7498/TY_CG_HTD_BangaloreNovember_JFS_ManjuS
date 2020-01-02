interface Trainee{
    name: string,
    age: number
    printTraineeDetails():void;
}
class Training implements Trainee{
    name: 'abc';
    age: 21;
    printTraineeDetails():void[
        Console.log('detials');
        
    ]

}
let trainee1:Trainee={
    name: 'manju',
    age: 21

}