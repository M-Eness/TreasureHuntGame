# Treasure Hunt Adventure

## Genel Bakış

**Treasure Hunt Adventure**, Java programlama dili ve NetBeans IDE kullanılarak geliştirilmiş bir oyundur. Oyunda kullanıcı zar atarak rastgele bir değer elde eder ve bu değere karşılık gelen noktaya ilerler. Oyuncunun geldiği noktanın türüne göre çeşitli olaylar gerçekleşir: puan kazanma/kaybetme, ileri/geri gitme gibi. Oyuncu haritanın sonuna ulaştığında bir üst seviyeye geçer.

Oyun toplamda 3 seviyeden oluşmaktadır. Harita, çok bağlantılı liste (Multi-Linked List) yapısıyla oluşturulmuştur. Puan tablosu, Binary Search Tree (BST) yapısıyla sıralanmaktadır. Ayrıca dosya işlemleri ve menü butonları gibi çeşitli bileşenler de oyuna entegre edilmiştir.

## Özellikler

- 🎲 Zar atma tabanlı hareket sistemi
- 📍 Özel noktalardan oluşan çok seviyeli harita:
  - **Treasure (Hazine)**: +10 puan
  - **Trap (Tuzak)**: -5 puan
  - **Mystery Box (Gizemli Kutu)**: +20 veya -10 (rastgele, Poison/Heal etkili)
  - **Forward / Backward (İleri / Geri)**
  - **Start (Başlangıç)**
  - **Poison (Zehir)** ve **Heal (İyileştirme)** etkileri
- 🧭 Çok bağlantılı liste ile gelişmiş harita navigasyonu (teleportasyon dahil)
- 🌳 Binary Search Tree ile puan kayıt ve sıralama sistemi
- 💾 Dosya tabanlı skor kayıt sistemi (`score.txt`)
- 🧑 Kullanıcıya özel skor takibi ve en yüksek/en düşük skor gösterimi
