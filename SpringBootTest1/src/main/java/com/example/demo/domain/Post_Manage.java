//package com.example.demo.domain;
//
//import java.util.ArrayList;
//
//public class Post_Manage {
//    public ArrayList<Post> post_lib= new ArrayList<Post>();
//    public void create_post(User user,String title,String details,String date){
//        Post discuss_post = new Post(user,date,title,details);
//        discuss_post.setId(post_lib.size()+1);
//        post_lib.add(discuss_post);
//    }
//    public boolean delete_post(int id){
//        for(int i = 0;i<post_lib.size();i++){
//            if (post_lib.get(i).getId()==id){
//                post_lib.remove(i);
//                return true;
//            }
//        }
//        return false;
//    }
//    public boolean edit_post(int id,String date,String detail){
//        for(int i = 0;i<post_lib.size();i++){
//            if (post_lib.get(i).getId()==id){
//                post_lib.get(i).setDetail(detail);
//                post_lib.get(i).setDate(date);
//                return true;
//            }
//        }
//        return false;
//    }
//    public boolean like(int id){
//        for(int i = 0;i<post_lib.size();i++){
//            if (post_lib.get(i).getId()==id){
//                int j = post_lib.get(i).getLikes();
//                post_lib.get(i).setLikes(j+1);
//                return true;
//            }
//        }
//        return false;
//    }
//
//    public ArrayList<Post> getPost_lib() {
//        return post_lib;
//    }
//}
