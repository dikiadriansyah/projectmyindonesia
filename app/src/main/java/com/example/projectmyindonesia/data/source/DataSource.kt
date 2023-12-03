package com.example.projectmyindonesia.data.source

import com.example.projectmyindonesia.R
import com.example.projectmyindonesia.data.MenuType
import com.example.projectmyindonesia.data.model.Data


object DataSource {

    val defaultData = Data(
        id = -1,
        judulTempatWisata = R.string.judul_template,
        imgResourceTempatWisata = R.drawable.lembangparkandzoo,
        deskripsiTempatWisata = R.string.deskripsi_template,
        type = MenuType.Museum

    )

    fun getAllData(): List<Data>{
        return listOf(
            Data(
                id = 1,
                judulTempatWisata = R.string.tempat1,
                imgResourceTempatWisata = R.drawable.lembangparkandzoo,
                deskripsiTempatWisata = R.string.desc1,
                type = MenuType.Wisata
            ),
            Data(
                id = 2,
                judulTempatWisata = R.string.tempat2,
                imgResourceTempatWisata = R.drawable.orchid_forest_cikole,
                deskripsiTempatWisata = R.string.desc2,
                type = MenuType.Wisata

            ),
            Data(
                id = 3,
                judulTempatWisata = R.string.tempat3,
                imgResourceTempatWisata = R.drawable.dusun_bambu,
                deskripsiTempatWisata = R.string.desc3,
                type = MenuType.Wisata

            ),
            Data(
                id = 4,
                judulTempatWisata = R.string.tempat4,
                imgResourceTempatWisata = R.drawable.farmhouse_lembang,
                deskripsiTempatWisata = R.string.desc4,
                type = MenuType.Wisata
            ),
            Data(
                id = 5,
                judulTempatWisata = R.string.tempat5,
                imgResourceTempatWisata = R.drawable.grafika_cikole,
                deskripsiTempatWisata = R.string.desc5,
                type = MenuType.Wisata
            ),
            Data(
                id = 6,
                judulTempatWisata = R.string.tempat6,
                imgResourceTempatWisata = R.drawable.taman_wisata_bougenvile,
                deskripsiTempatWisata = R.string.desc6,
                type = MenuType.Wisata
            ),
            Data(
                id = 7,
                judulTempatWisata = R.string.tempat7,
                imgResourceTempatWisata = R.drawable.tangkuban_perahu,
                deskripsiTempatWisata = R.string.desc7,
                type = MenuType.Wisata
            ),
            Data(
                id = 8,
                judulTempatWisata = R.string.tempat8,
                imgResourceTempatWisata = R.drawable.pantai_sanur,
                deskripsiTempatWisata = R.string.desc8,
                type = MenuType.Wisata
            ),
            Data(
                id = 9,
                judulTempatWisata = R.string.tempat9,
                imgResourceTempatWisata = R.drawable.pusat_konvervasi_dan_pendidikan_penyu,
                deskripsiTempatWisata = R.string.desc9,
                type = MenuType.Museum
            ),
            Data(
                id = 10,
                judulTempatWisata = R.string.tempat10,
                imgResourceTempatWisata = R.drawable.pantai_sindhu,
                deskripsiTempatWisata = R.string.desc10,
                type = MenuType.Wisata
            ),
            Data(
                id = 11,
                judulTempatWisata = R.string.tempat11,
                imgResourceTempatWisata = R.drawable.monumen_bajra_sandhi,
                deskripsiTempatWisata = R.string.desc11,
                type = MenuType.Museum
            ),
            Data(
                id = 12,
                judulTempatWisata = R.string.tempat12,
                imgResourceTempatWisata = R.drawable.pantai_cemara,
                deskripsiTempatWisata = R.string.desc12,
                type = MenuType.Wisata
            ),
            Data(
                id = 13,
                judulTempatWisata = R.string.tempat13,
                imgResourceTempatWisata = R.drawable.serangan_beach,
                deskripsiTempatWisata = R.string.desc13,
                type = MenuType.Wisata
            ),
            Data(
                id = 14,
                judulTempatWisata = R.string.tempat14,
                imgResourceTempatWisata = R.drawable.pantai_mertasari,
                deskripsiTempatWisata = R.string.desc14,
                type = MenuType.Wisata
            ),
            Data(
                id = 15,
                judulTempatWisata = R.string.tempat15,
                imgResourceTempatWisata = R.drawable.ragunan__ragunan_zoo,
                deskripsiTempatWisata = R.string.desc15,
                type = MenuType.Wisata
            ),
            Data(
                id = 16,
                judulTempatWisata = R.string.tempat16,
                imgResourceTempatWisata = R.drawable.taman_mini,
                deskripsiTempatWisata = R.string.desc16,
                type = MenuType.Wisata
            ),
            Data(
                id = 17,
                judulTempatWisata = R.string.tempat17,
                imgResourceTempatWisata = R.drawable.monumen_nasional,
                deskripsiTempatWisata = R.string.desc17,
                type = MenuType.Wisata
            ),
            Data(
                id = 18,
                judulTempatWisata = R.string.tempat18,
                imgResourceTempatWisata = R.drawable.museum_bank_indonesia,
                deskripsiTempatWisata = R.string.desc18,
                type = MenuType.Museum
            ),
            Data(
                id = 19,
                judulTempatWisata = R.string.tempat19,
                imgResourceTempatWisata = R.drawable.setu_babakan,
                deskripsiTempatWisata = R.string.desc19,
                type = MenuType.Wisata
            ),
            Data(
                id = 20,
                judulTempatWisata = R.string.tempat20,
                imgResourceTempatWisata = R.drawable.planetarium,
                deskripsiTempatWisata = R.string.desc20,
                type = MenuType.Wisata
            ),
            Data(
                id = 21,
                judulTempatWisata = R.string.tempat21,
                imgResourceTempatWisata = R.drawable.kota_tua,
                deskripsiTempatWisata = R.string.desc21,
                type = MenuType.Wisata
            ),
            Data(
                id = 22,
                judulTempatWisata = R.string.tempat22,
                imgResourceTempatWisata = R.drawable.candi_borobudur,
                deskripsiTempatWisata = R.string.desc22,
                type = MenuType.Wisata
            ),
            Data(
                id = 23,
                judulTempatWisata = R.string.tempat23,
                imgResourceTempatWisata = R.drawable.candi_prambanan,
                deskripsiTempatWisata = R.string.desc23,
                type = MenuType.Wisata
            ),
            Data(
                id = 24,
                judulTempatWisata = R.string.tempat24,
                imgResourceTempatWisata = R.drawable.malioboro,
                deskripsiTempatWisata = R.string.desc24,
                type = MenuType.Wisata
            ),
            Data(
                id = 25,
                judulTempatWisata = R.string.tempat25,
                imgResourceTempatWisata = R.drawable.heha_ocean_view,
                deskripsiTempatWisata = R.string.desc25,
                type = MenuType.Wisata
            ),
            Data(
                id = 26,
                judulTempatWisata = R.string.tempat26,
                imgResourceTempatWisata = R.drawable.taman_sari_jogja,
                deskripsiTempatWisata = R.string.desc26,
                type = MenuType.Wisata
            ),
            Data(
                id = 27,
                judulTempatWisata = R.string.tempat27,
                imgResourceTempatWisata = R.drawable.pantai_parangtritis,
                deskripsiTempatWisata = R.string.desc27,
                type = MenuType.Wisata
            ),
            Data(
                id = 28,
                judulTempatWisata = R.string.tempat28,
                imgResourceTempatWisata = R.drawable.gunung_merapi,
                deskripsiTempatWisata = R.string.desc28,
                type = MenuType.Wisata
            ),
            Data(
                id = 29,
                judulTempatWisata = R.string.tempat29,
                imgResourceTempatWisata = R.drawable.batu_flower_garden,
                deskripsiTempatWisata = R.string.desc29,
                type = MenuType.Wisata
            ),
            Data(
                id = 30,
                judulTempatWisata = R.string.tempat30,
                imgResourceTempatWisata = R.drawable.pantai_parang_dowo,
                deskripsiTempatWisata = R.string.desc30,
                type = MenuType.Wisata
            ),
            Data(
                id = 31,
                judulTempatWisata = R.string.tempat31,
                imgResourceTempatWisata = R.drawable.alun_alun_malang,
                deskripsiTempatWisata = R.string.desc31,
                type = MenuType.Wisata
            ),
            Data(
                id = 32,
                judulTempatWisata = R.string.tempat32,
                imgResourceTempatWisata = R.drawable.museum_angkut_malang,
                deskripsiTempatWisata = R.string.desc32,
                type = MenuType.Wisata
            ),
            Data(
                id = 33,
                judulTempatWisata = R.string.tempat33,
                imgResourceTempatWisata = R.drawable.jatimpark1,
                deskripsiTempatWisata = R.string.desc33,
                type = MenuType.Wisata
            ),
            Data(
                id = 34,
                judulTempatWisata = R.string.tempat34,
                imgResourceTempatWisata = R.drawable.pantai_balekambang,
                deskripsiTempatWisata = R.string.desc34,
                type = MenuType.Wisata
            ),
            Data(
                id = 35,
                judulTempatWisata = R.string.tempat35,
                imgResourceTempatWisata = R.drawable.bukit_nirwana2,
                deskripsiTempatWisata = R.string.desc35,
                type = MenuType.Wisata
            ),
            Data(
                id = 36,
                judulTempatWisata = R.string.tempat36,
                imgResourceTempatWisata = R.drawable.lawang_sewu,
                deskripsiTempatWisata = R.string.desc36,
                type = MenuType.Wisata
            ),
            Data(
                id = 37,
                judulTempatWisata = R.string.tempat37,
                imgResourceTempatWisata = R.drawable.saloka_theme_park2,
                deskripsiTempatWisata = R.string.desc37,
                type = MenuType.Wisata
            ),
            Data(
                id = 38,
                judulTempatWisata = R.string.tempat38,
                imgResourceTempatWisata = R.drawable.dusun_semilir_semarang,
                deskripsiTempatWisata = R.string.desc38,
                type = MenuType.Wisata
            ),
            Data(
                id = 39,
                judulTempatWisata = R.string.tempat39,
                imgResourceTempatWisata = R.drawable.taman_wilis,
                deskripsiTempatWisata = R.string.desc39,
                type = MenuType.Wisata
            ),
            Data(
                id = 40,
                judulTempatWisata = R.string.tempat40,
                imgResourceTempatWisata = R.drawable.candi_gedong_songo,
                deskripsiTempatWisata = R.string.desc40,
                type = MenuType.Museum
            ),
            Data(
                id = 41,
                judulTempatWisata = R.string.tempat41,
                imgResourceTempatWisata = R.drawable.museum_kereta_api_ambarawa,
                deskripsiTempatWisata = R.string.desc41,
                type = MenuType.Wisata
            ),
            Data(
                id = 42,
                judulTempatWisata = R.string.tempat42,
                imgResourceTempatWisata = R.drawable.pantai_marina_kalianda,
                deskripsiTempatWisata = R.string.desc42,
                type = MenuType.Wisata
            )
        )
    }
}