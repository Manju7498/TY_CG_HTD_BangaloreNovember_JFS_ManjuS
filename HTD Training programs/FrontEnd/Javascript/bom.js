let latitude;
let longitude;
navigator.geolocation.getCurrentPosition((position)=>{
console.log('latitude',position.coords.latitude);
latitude=position.coords.latitude;
console.log('longitude',position.coords.longitude);
longitude=position.coords.longitude;
});
let heading=document.getElementById('heading');
heading.style.background='red';
heading.style.color='white';
function acceptProposal() {
    document.getElementById('proposal').src='https://cdn.pixabay.com/photo/2017/01/04/21/00/new-years-eve-1953253__340.jpg';
}
function rejectProposal() {
    document.getElementById('proposal').src='https://cdn.pixabay.com/photo/2017/11/26/15/16/smiley-2979107__340.jpg';
}