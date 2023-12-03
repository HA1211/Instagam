package com.nqh.instagram.Fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.nqh.instagram.Adapters.PostAdapter
import com.nqh.instagram.Model.PostModel
import com.nqh.instagram.RetrofitClient
import com.nqh.instagram.UserService
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
            PostModel("", "", "Hiep 1", ""),
            PostModel("", "", "Hiep 2", ""),
            PostModel("", "", "Hiep 3", ""),
            PostModel("", "", "Hiep 4", ""),
            PostModel("", "", "Hiep 5", ""),
            PostModel("", "", "Hiep 5", ""),
            PostModel("", "", "Hiep 5", ""),
            PostModel("", "", "Hiep 5", ""),
            PostModel("", "", "Hiep 5", ""),
            PostModel("", "", "Hiep 6", "")
        )
        val adapter = PostAdapter(listString)
        binding.rcyNews.adapter = adapter

        val call = RetrofitClient.apiInterface.getData()
        call.enqueue(object : Callback<List<UserService>> {
            override fun onResponse(
                call: Call<List<UserService>>,
                response: Response<List<UserService>>
            ) {

                val data : List<UserService> = response.body() as List<UserService>

                Log.d("hiep", "data: " + data.size)
            }

            override fun onFailure(call: Call<List<UserService>>, t: Throwable) {
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