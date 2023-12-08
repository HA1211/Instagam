package com.nqh.instagram.Fragment

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.nqh.instagram.Activity.PostDetailActivity
import com.nqh.instagram.Adapters.PostAdapter
import com.nqh.instagram.Model.InterfaceModel
import com.nqh.instagram.Model.PostModel
import com.nqh.instagram.RetrofitClient
import com.nqh.instagram.databinding.FragmentHomeBinding
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody.Companion.toRequestBody
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val listString = listOf<PostModel>(


            PostModel("", "", "Hiep 1", "https://zipoapps-storage-battery-charging-animation.nyc3.cdn.digitaloceanspaces.com/animations/new/new19.jpeg"),
            PostModel("", "", "Hiep 2", "https://zipoapps-storage-battery-charging-animation.nyc3.cdn.digitaloceanspaces.com/animations/new/new19.jpeg"),
            PostModel("", "", "Hiep 3", "https://zipoapps-storage-battery-charging-animation.nyc3.cdn.digitaloceanspaces.com/animations/new/new19.jpeg"),
            PostModel("", "", "Hiep 4", "https://zipoapps-storage-battery-charging-animation.nyc3.cdn.digitaloceanspaces.com/animations/new/new19.jpeg"),
            PostModel("", "", "Hiep 5", "https://zipoapps-storage-battery-charging-animation.nyc3.cdn.digitaloceanspaces.com/animations/new/new19.jpeg"),
            PostModel("", "", "Hiep 5", "https://zipoapps-storage-battery-charging-animation.nyc3.cdn.digitaloceanspaces.com/animations/new/new19.jpeg"),
            PostModel("", "", "Hiep 5", "https://zipoapps-storage-battery-charging-animation.nyc3.cdn.digitaloceanspaces.com/animations/new/new19.jpeg"),
            PostModel("", "", "Hiep 5", "https://zipoapps-storage-battery-charging-animation.nyc3.cdn.digitaloceanspaces.com/animations/new/new19.jpeg"),
            PostModel("", "", "Hiep 5", "https://zipoapps-storage-battery-charging-animation.nyc3.cdn.digitaloceanspaces.com/animations/new/new19.jpeg"),
            PostModel("", "", "Hiep 6", "")
        )

        val call = RetrofitClient.apiInterface.getData()
        call.enqueue(object : Callback<List<PostModel>> {
            override fun onResponse(
                call: Call<List<PostModel>>,
                response: Response<List<PostModel>>
            ) {

                val data : List<PostModel> = response.body() as List<PostModel>

                val adapter = PostAdapter(data, requireContext(), object : InterfaceModel{
                    override fun click(postModel: PostModel) {
                        startActivity(Intent(requireContext(), PostDetailActivity::class.java))
                    }

                })
                binding.rcyNews.adapter = adapter

                Log.d("hiep", "data: " + data.size)
            }

            override fun onFailure(call: Call<List<PostModel>>, t: Throwable) {
                Log.d("hiep", "khong call dc")
                t.printStackTrace()
            }
        })

        /*val json = JSONObject()

        json.put(
            "name",
            "hiep")
        json.put(
            "avatar",
            "https://cloudflare-ipfs.com/ipfs/Qmd3W5DuhgHirLHGVixi6V76LhCkZUz6pnFt5AJBiyvHye/avatar/357.jpg"
        )

        val requestBody = json.toString().toRequestBody("application/json".toMediaTypeOrNull())

        val call = RetrofitClient.apiInterface.addNewUser(
            requestBody
        )

        call.enqueue(object : Callback<UserService> {
            override fun onResponse(call: Call<UserService>, response: Response<UserService>) {
                Log.d("hiep", "onResponse")
            }

            override fun onFailure(call: Call<UserService>, t: Throwable) {
                Log.d("hiep", "onFailure")
            }
        })*/
    }
}