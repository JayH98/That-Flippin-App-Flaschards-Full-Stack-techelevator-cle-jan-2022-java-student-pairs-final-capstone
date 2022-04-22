<template>
  <div class="meet-us-title">
    <h2 style="color:#00ADEE">Meet The Creative Team</h2>
    <div>
      <!-- Team # Octothorpe - Flash Cards -->
      <p style="color:#999DA0">
        We are the awesome Team # Octothorpe! Heed our
        Flash Cards and become more knowledgeable!
      </p>
      
      <ul id="all-bios">

       <a id="daniloPA" class="LinkedIn-img-link" href="https://www.linkedin.com/in/danilo-pivaral-alvarez-20a905170/" data-LinkedIn-hook-img="link">
        <!-- <img id="LinkedIn-logo" src="@/assets/LinkedInLogo.png" data-LinkedIn-hook-img="img" alt="LinkedIn Logo"> -->
        <img id="LinkedIn-DPA" src="https://media-exp1.licdn.com/dms/image/C4E03AQG20ZpXUctblg/profile-displayphoto-shrink_400_400/0/1645323886699?e=1655942400&v=beta&t=3AN4_7-F22mYIJ86EYcX98g7KAIOesUE_igfjx6FaDM" 
          data-LinkedIn-hook-img="img" alt="LinkedIn DPA profile pic">
        <br />
        Danilo Pivaral-Alvarez  
       </a>

       <a id="graysonG" class="LinkedIn-img-link" href="https://www.linkedin.com/in/dan-grayson-gregg/" data-LinkedIn-hook-img="link">
        <!-- <img id="LinkedIn-logo" src="@/assets/LinkedInLogo.png" data-LinkedIn-hook-img="img" alt="LinkedIn Logo"> -->
        <img id="LinkedIn-DGG" src="https://media-exp1.licdn.com/dms/image/C5603AQFu2-Bkopv5ZQ/profile-displayphoto-shrink_400_400/0/1650422965333?e=1655942400&v=beta&t=TJCv9ji8e7OzrlTc9h2OHM1SZniW44ieGixW2t1i9V0" 
          data-LinkedIn-hook-img="img" alt="LinkedIn DGG profile pic">
        <br />
        Dan (Grayson) Gregg
       </a>

       <a id="angelS" class="LinkedIn-img-link" href="https://www.linkedin.com/in/avscott/" >
        <!-- <img id="LinkedIn-logo" src="@/assets/LinkedInLogo.png" data-LinkedIn-hook-img="img" alt="LinkedIn Logo"> -->
        <img id="LinkedIn-AS" src="https://media-exp1.licdn.com/dms/image/C4D03AQGrw_TsrIutLQ/profile-displayphoto-shrink_400_400/0/1646151506591?e=1655942400&v=beta&t=h1eJPc9bd9BiOuXDkxQ2Hosf6N_Wk-M9jxVZfFro-qY" 
          data-LinkedIn-hook-img="img" alt="LinkedIn AS profile pic">
        <br />
        Angel Scott
       </a>

       <a id="jayH" class="LinkedIn-img-link" href="https://www.linkedin.com/in/jeleah-hill/" data-LinkedIn-hook-img="link">
        <!-- <img id="LinkedIn-logo" src="@/assets/LinkedInLogo.png" data-LinkedIn-hook-img="img" alt="LinkedIn Logo"> -->
        <img id="LinkedIn-JH" src="https://media-exp1.licdn.com/dms/image/C5603AQHTl2z3CGfd_A/profile-displayphoto-shrink_100_100/0/1642283956471?e=1655942400&v=beta&t=jhGh_hpkaU0d0D3iUTwb1D62ogwSTfGRwwbgxGb_tgs" 
          data-LinkedIn-hook-img="img" alt="LinkedIn JH profile pic">
        <br />
        JeLeah (Jay) Hill
       </a>

       <a id="kevinS" class="LinkedIn-img-link" href="https://www.linkedin.com/in/kevinrsteinbach/" data-LinkedIn-hook-img="link">
        <!-- <img id="LinkedIn-logo" src="@/assets/LinkedInLogo.png" data-LinkedIn-hook-img="img" alt="LinkedIn Logo"> -->
        <img id="LinkedIn-KS" src="https://media-exp1.licdn.com/dms/image/C4E03AQGK5zJCNe1c7g/profile-displayphoto-shrink_400_400/0/1644354324272?e=1655942400&v=beta&t=ca6IXC-bIWeYpkqbpyF0oHWLrpAEt_vVufnV0SEYoY0" 
          data-LinkedIn-hook-img="img" alt="LinkedIn KS profile pic">
        <br />
        Kevin Steinbach
       </a>
        
      </ul>
    </div>
  </div>
</template>


<script>
export default {
  name: "meet-us",
  
};
</script>


<style>

h2#meet-us {
  color: #00ADEE;
  background: #71D96F;
}

ul {
  height: 30%;  
}

a {
width: 150px;
}

a#angelS, a#daniloPA, a#graysonG, a#jayH , a#kevinS  {
  align-items: center;
  text-align: center;
  height: 200px;
  padding-bottom: 0px;
  display: block;
  margin-left: auto;
  margin-right: auto;
  width: 50%;
}

img {
  align-items: center;
  height: 150px;
}

#all-bios{
  position: relative;
  background-image: url('../assets/notecard.png');
  background-size:cover;
  height: 400px;
  align-items: center; 
}





</style>


