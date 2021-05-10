package com.socialmediapost.insta.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.socialmediapost.fb.dto.PostHomeListingCommerceManagerRequest;
import com.socialmediapost.fb.dto.PostMessageResponse;
import com.socialmediapost.fb.dto.longLivedToken;
import com.socialmediapost.fb.dto.pageTokenResponse;
import com.socialmediapost.insta.dto.InstaContainerImagePostRequest;
import com.socialmediapost.insta.dto.InstaContainerImagePostResponse;


@RestController
public class InstaPostController {

	@Autowired
	private RestTemplate restTemplate;
	
	private String access_token = "";

	  @PostMapping(path = "/insta/postImages")
	  public List<InstaContainerImagePostResponse> postHomeListings(@RequestBody InstaContainerImagePostRequest imagePostRequest ) {

			  longLivedToken longLivedToken = longLivedToken(); 
			  pageTokenResponse pageTokenResponse = pageAccessToken(longLivedToken);
			  imagePostRequest.setAccess_token(pageTokenResponse.getAccess_token());
			  access_token = pageTokenResponse.getAccess_token();
			
			  
			  
			  
			  ArrayList<String> imageList = getImages();
			  
			  Iterator<String> iterator = imageList.iterator();
			  
			  List<InstaContainerImagePostResponse> listResponse = new ArrayList<InstaContainerImagePostResponse>();
			  
			  while(iterator.hasNext()) {
				 
				  imagePostRequest.setImage_url(iterator.next());
				  System.out.println("image_url"+imagePostRequest.getImage_url());
				  //Create an image container and post the images to instagram
				  InstaContainerImagePostResponse messageResponse = createImageContainersInsta(imagePostRequest); 
				  messageResponse = publishImageContainersInsta(messageResponse);
				  listResponse.add(messageResponse);
			  }
			  
			  return listResponse;

	  }
	  
		private InstaContainerImagePostResponse publishImageContainersInsta(InstaContainerImagePostResponse containerImagePostResponse) {
			String uri = "https://graph.facebook.com/v10.0/17841400151054043/media_publish?creation_id="+containerImagePostResponse.getId()
			+"&access_token="+access_token;
			
			System.out.println(uri);
			
			  HttpHeaders headers = new HttpHeaders();
			  headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

			  HttpEntity<InstaContainerImagePostResponse> entity = new HttpEntity<InstaContainerImagePostResponse>(headers);
			  
			  InstaContainerImagePostResponse imagePostResponse= restTemplate.postForObject(uri, entity, InstaContainerImagePostResponse.class);
			
			return imagePostResponse;
		}

	private InstaContainerImagePostResponse createImageContainersInsta(InstaContainerImagePostRequest imagePostRequest) {
		String uri = "https://graph.facebook.com/v10.0/17841400151054043/media?"
				+ "image_url="+imagePostRequest.getImage_url()
				+ "access_token="+imagePostRequest.getAccess_token();
		
		  HttpHeaders headers = new HttpHeaders();
		  headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

		  HttpEntity<InstaContainerImagePostRequest> entity = new HttpEntity<InstaContainerImagePostRequest>(imagePostRequest);
		  
		  InstaContainerImagePostResponse imagePostResponse= restTemplate.postForObject(uri, entity, InstaContainerImagePostResponse.class);
		
		return imagePostResponse;
	}

	private longLivedToken longLivedToken() {
		String uri = "https://graph.facebook.com/oauth/access_token?grant_type=fb_exchange_token"
		  		+ "&client_id=391782198535970&client_secret=2e59ad3d37d98dbca63ace26f6c70852"
		  		+ "&fb_exchange_token="
		  		+ "EAAFkUubF5yIBAHWSV8Tr2wRUwtHbKMDciyNe8NYHo4FZC8RSFoSzWZCp4VZCjLawNBZAZASkn1ZCHbDJGa3GE2HBTljuHJfBmuj4RXiuaVEKc4spRSiiPKDba9ajsbvKxMR00aYZAaLhopEeSFOnkZBZAGThKZAOqgcTN4f0BL6Ls0jfAU6MXBSNL5elxFI8wFDtYPnNG8frAvzQZDZD";
		  
		  longLivedToken longLivedToken = restTemplate.getForObject(uri,longLivedToken.class);
		return longLivedToken;
	}

	private pageTokenResponse pageAccessToken(longLivedToken livedToken) {
		String uri = "https://graph.facebook.com/110549761173781?"
				+ "fields=access_token"
				+ "&access_token="+livedToken.getAccess_token();
		  
		pageTokenResponse pageTokenResponse = restTemplate.getForObject(uri,pageTokenResponse.class);
		return pageTokenResponse;
	}
	
	private ArrayList<String> getImages(){
		ArrayList<String> imageList = new ArrayList<String>();
		imageList.add("https://media.istockphoto.com/photos/beautiful-luxury-home-exterior-at-twilight-picture-id1026205392?k=6&m=1026205392&s=612x612&w=0&h=pe0Pqbm7GKHl7cmEjf9Drc7Fp-JwJ6aTywsGfm5eQm4=");
		imageList.add("https://i.pinimg.com/564x/c9/aa/f8/c9aaf8853557c381c80ee827db0dad64.jpg");
		imageList.add("https://hgtvhome.sndimg.com/content/dam/images/hgtv/fullset/2019/9/16/0/IO_Tongue-and-Groove_Beech-Street_3.jpg.rend.hgtvcom.616.411.suffix/1568648112267.jpeg");
		imageList.add("https://i.pinimg.com/originals/4d/9d/d6/4d9dd658da8a62f5f9726c903af2be98.jpg");
		//imageList.add("https://www.rocketmortgage.com/resources-cmsassets/RocketMortgage.com/Article_Images/Large_Images/TypesOfHomes/types-of-homes-hero.jpg");
		
		  imageList.add(
		  "https://media.architecturaldigest.in/wp-content/uploads/2020/11/ghaziabad-uttar-pradesh-homes-photos-1366x768.jpg"
		  ); 
		  //imageList.add("https://www.rocketmortgage.com/resources-cmsassets/RocketMortgage.com/Article_Images/Large_Images/TypesOfHomes/types-of-homes-hero.jpg"); 
		  imageList.add(
		  "https://akm-img-a-in.tosshub.com/sites/btmt/images/stories/home-loan_660_020117053409_030917101300_103018074036.jpg"
		  ); imageList.add(
		  "https://static.toiimg.com/thumb/msid-77440426,imgsize-196127,width-400,resizemode-4/77440426.jpg"
			); /*
				 * imageList.add(
				 * "http://www.acehomes.in/wp-content/uploads/2019/05/plot-4-pic-1.jpg");
				 */
		  imageList.add(
		  "https://is1-2.housingcdn.com/4f2250e8/d989169406d3d2b03125b6a6aabd597b/v5/fs/2_bhk_apartment-for-rent-kuldiha_1-Durgapur.jpg"
		  ); imageList.add(
		  "https://imagesvc.meredithcorp.io/v3/mm/image?url=https%3A%2F%2Fstatic.onecms.io%2Fwp-content%2Fuploads%2Fsites%2F37%2F2019%2F06%2F12170406%2Fmodern-home-exterior-gray-scheme-792ab713.jpg"
		  ); imageList.add(
		  "https://i.pinimg.com/originals/b4/b9/aa/b4b9aac0fd4a6efd448db56874b15326.jpg"
		  ); imageList.add(
		  "https://media.istockphoto.com/photos/beautiful-luxury-home-exterior-at-twilight-picture-id1026205392?k=6&m=1026205392&s=612x612&w=0&h=pe0Pqbm7GKHl7cmEjf9Drc7Fp-JwJ6aTywsGfm5eQm4="
		  ); imageList.add(
		  "https://i.pinimg.com/564x/c9/aa/f8/c9aaf8853557c381c80ee827db0dad64.jpg");
		  imageList.add(
		  "https://hgtvhome.sndimg.com/content/dam/images/hgtv/fullset/2019/9/16/0/IO_Tongue-and-Groove_Beech-Street_3.jpg.rend.hgtvcom.616.411.suffix/1568648112267.jpeg"
		  ); imageList.add(
		  "https://i.pinimg.com/originals/4d/9d/d6/4d9dd658da8a62f5f9726c903af2be98.jpg"
		  ); 
		  /*imageList.add(
		  "https://www.rocketmortgage.com/resources-cmsassets/RocketMortgage.com/Article_Images/Large_Images/TypesOfHomes/types-of-homes-hero.jpg"
		  ); */
		  imageList.add(
		  "https://media.architecturaldigest.in/wp-content/uploads/2020/11/ghaziabad-uttar-pradesh-homes-photos-1366x768.jpg"
		  ); imageList.add(
		  "https://www.rocketmortgage.com/resources-cmsassets/RocketMortgage.com/Article_Images/Large_Images/TypesOfHomes/types-of-homes-hero.jpg"
		  ); imageList.add(
		  "https://akm-img-a-in.tosshub.com/sites/btmt/images/stories/home-loan_660_020117053409_030917101300_103018074036.jpg"
		  ); imageList.add(
		  "https://static.toiimg.com/thumb/msid-77440426,imgsize-196127,width-400,resizemode-4/77440426.jpg"
			); /*
				 * imageList.add(
				 * "");
				 */
		  imageList.add(
		  "https://is1-2.housingcdn.com/4f2250e8/d989169406d3d2b03125b6a6aabd597b/v5/fs/2_bhk_apartment-for-rent-kuldiha_1-Durgapur.jpg"
		  ); imageList.add(
		  "https://imagesvc.meredithcorp.io/v3/mm/image?url=https%3A%2F%2Fstatic.onecms.io%2Fwp-content%2Fuploads%2Fsites%2F37%2F2019%2F06%2F12170406%2Fmodern-home-exterior-gray-scheme-792ab713.jpg"
		  ); imageList.add(
		  "https://i.pinimg.com/originals/b4/b9/aa/b4b9aac0fd4a6efd448db56874b15326.jpg"
		  ); imageList.add(
		  "https://media.istockphoto.com/photos/beautiful-luxury-home-exterior-at-twilight-picture-id1026205392?k=6&m=1026205392&s=612x612&w=0&h=pe0Pqbm7GKHl7cmEjf9Drc7Fp-JwJ6aTywsGfm5eQm4="
		  ); imageList.add(
		  "https://i.pinimg.com/564x/c9/aa/f8/c9aaf8853557c381c80ee827db0dad64.jpg");
		  imageList.add(
		  "https://hgtvhome.sndimg.com/content/dam/images/hgtv/fullset/2019/9/16/0/IO_Tongue-and-Groove_Beech-Street_3.jpg.rend.hgtvcom.616.411.suffix/1568648112267.jpeg"
		  ); imageList.add(
		  "https://i.pinimg.com/originals/4d/9d/d6/4d9dd658da8a62f5f9726c903af2be98.jpg"
		  ); imageList.add(
		  "https://www.rocketmortgage.com/resources-cmsassets/RocketMortgage.com/Article_Images/Large_Images/TypesOfHomes/types-of-homes-hero.jpg"
		  ); imageList.add(
		  "https://media.architecturaldigest.in/wp-content/uploads/2020/11/ghaziabad-uttar-pradesh-homes-photos-1366x768.jpg"
		  ); imageList.add(
		  "https://www.rocketmortgage.com/resources-cmsassets/RocketMortgage.com/Article_Images/Large_Images/TypesOfHomes/types-of-homes-hero.jpg"
		  ); imageList.add(
		  "https://akm-img-a-in.tosshub.com/sites/btmt/images/stories/home-loan_660_020117053409_030917101300_103018074036.jpg"
		  ); imageList.add(
		  "https://static.toiimg.com/thumb/msid-77440426,imgsize-196127,width-400,resizemode-4/77440426.jpg"
		  ); imageList.add(
		  "");
		  imageList.add(
		  "https://is1-2.housingcdn.com/4f2250e8/d989169406d3d2b03125b6a6aabd597b/v5/fs/2_bhk_apartment-for-rent-kuldiha_1-Durgapur.jpg"
		  ); imageList.add(
		  "https://imagesvc.meredithcorp.io/v3/mm/image?url=https%3A%2F%2Fstatic.onecms.io%2Fwp-content%2Fuploads%2Fsites%2F37%2F2019%2F06%2F12170406%2Fmodern-home-exterior-gray-scheme-792ab713.jpg"
		  ); imageList.add(
		  "https://i.pinimg.com/originals/b4/b9/aa/b4b9aac0fd4a6efd448db56874b15326.jpg"
		  ); imageList.add(
		  "https://media.istockphoto.com/photos/beautiful-luxury-home-exterior-at-twilight-picture-id1026205392?k=6&m=1026205392&s=612x612&w=0&h=pe0Pqbm7GKHl7cmEjf9Drc7Fp-JwJ6aTywsGfm5eQm4="
		  ); imageList.add(
		  "https://i.pinimg.com/564x/c9/aa/f8/c9aaf8853557c381c80ee827db0dad64.jpg");
		  imageList.add(
		  "https://hgtvhome.sndimg.com/content/dam/images/hgtv/fullset/2019/9/16/0/IO_Tongue-and-Groove_Beech-Street_3.jpg.rend.hgtvcom.616.411.suffix/1568648112267.jpeg"
		  ); imageList.add(
		  "https://i.pinimg.com/originals/4d/9d/d6/4d9dd658da8a62f5f9726c903af2be98.jpg"
		  ); imageList.add(
		  "https://www.rocketmortgage.com/resources-cmsassets/RocketMortgage.com/Article_Images/Large_Images/TypesOfHomes/types-of-homes-hero.jpg"
		  ); imageList.add(
		  "https://media.architecturaldigest.in/wp-content/uploads/2020/11/ghaziabad-uttar-pradesh-homes-photos-1366x768.jpg"
		  ); imageList.add(
		  "https://www.rocketmortgage.com/resources-cmsassets/RocketMortgage.com/Article_Images/Large_Images/TypesOfHomes/types-of-homes-hero.jpg"
		  ); imageList.add(
		  "https://akm-img-a-in.tosshub.com/sites/btmt/images/stories/home-loan_660_020117053409_030917101300_103018074036.jpg"
		  ); imageList.add(
		  "https://static.toiimg.com/thumb/msid-77440426,imgsize-196127,width-400,resizemode-4/77440426.jpg"
			); /*
				 * imageList.add(
				 * "http://www.acehomes.in/wp-content/uploads/2019/05/plot-4-pic-1.jpg");
				 */
		  imageList.add(
		  "https://is1-2.housingcdn.com/4f2250e8/d989169406d3d2b03125b6a6aabd597b/v5/fs/2_bhk_apartment-for-rent-kuldiha_1-Durgapur.jpg"
		  ); imageList.add(
		  "https://imagesvc.meredithcorp.io/v3/mm/image?url=https%3A%2F%2Fstatic.onecms.io%2Fwp-content%2Fuploads%2Fsites%2F37%2F2019%2F06%2F12170406%2Fmodern-home-exterior-gray-scheme-792ab713.jpg"
		  ); imageList.add(
		  "https://i.pinimg.com/originals/b4/b9/aa/b4b9aac0fd4a6efd448db56874b15326.jpg"
		  );
		 		
		return imageList;
	}
}
