package com.example.android10googlemap

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    // lateinit : 초기화
    // 초기화를 할때 약간의 지연을 시켜서 해줘야하는 경우(천천히 초기화하는 경우) 사용
    // 선언만 하고 초기화는 나중에 할게,,
    // ldate : 필요할때 초기화
    // lazy : 변수를 선언할때 초기화 by lazy로 사용
    private lateinit var mMap: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
                .findFragmentById(R.id.map) as SupportMapFragment
        // async: 비동기통신(=스레드)
        // 메인 루틴이 아닌 서브 루틴으로 돌리겠다는 얘기
        // 지도를 뿌리는데 동기로 뿌리는게 아니고 비동기로 처리한 다음 화면에 보이겠다
        mapFragment.getMapAsync(this/*main activity*/)
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {
        // 준비가 된게 확실할때 mMap을 초기화하겠다
        mMap = googleMap

        // Add a marker in Sydney and move the camera
        // lat위도 lng경도
        val ggyd = LatLng(37.481456, 126.883219)
        mMap.addMarker(MarkerOptions().position(ggyd).title("Marker in Gasan Subway"))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(ggyd))
    }
}