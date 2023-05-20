package com.gdg.composestudy23_5week

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RadioViewModel @Inject constructor() : ViewModel() {
    val list = listOf(
        ListItem.RadioMusic(
            "Apple Music 1",
            "놓쳐서는 안 될 신곡",
            "실시간 · 오후 9시 ~ 오전 12시",
            ListItem.MusicStation("", "", R.drawable.img_box_1)
        ),
        ListItem.RadioMusic(
            "Apple Music Hits",
            "시대를 초월해 사랑받는 히트곡",
            "실시간 · 오후 9:00 ~ 10:25",
            ListItem.MusicStation("", "", R.drawable.img_box_2)
        ),
        ListItem.RadioMusic(
            "Apple Music Country",
            "컨트리 팬들을 위한 보석 상자",
            "실시간 · 오후 9시 ~ 10시",
            ListItem.MusicStation("", "", R.drawable.img_box_3)
        ),
        ListItem.StationsByGenre(
            listOf(
                ListItem.MusicStation("Title1", "Description", R.drawable.img_box_4),
                ListItem.MusicStation("Title2", "Description", R.drawable.img_box_5),
                ListItem.MusicStation("Title3", "Description", R.drawable.img_box_6),
                ListItem.MusicStation("Title4", "Description", R.drawable.img_box_7),
                ListItem.MusicStation("Title4", "Description", R.drawable.img_box_8)
            )
        ),
        ListItem.More("댄스"),
        ListItem.More("라틴"),
        ListItem.More("록"),
        ListItem.More("메탈"),
        ListItem.More("싱어송라이터"),
        ListItem.More("얼터너티브 & 인디 음악"),
        ListItem.More("월드 뮤직"),
        ListItem.More("일렉트로닉"),
        ListItem.More("재즈"),
        ListItem.More("컨트리"),
        ListItem.More("클래식"),
        ListItem.More("키즈 & 패밀리"),
        ListItem.More("팝"),
        ListItem.More("힙합/R&B"),
        ListItem.More("CCM")
    )
}