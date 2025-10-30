package com.example.duolingo.data.data_source

import io.github.jan.supabase.auth.Auth
import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.postgrest.Postgrest
import io.github.jan.supabase.realtime.Realtime
import io.github.jan.supabase.storage.Storage

object InitSupabaseClient {
    val client = createSupabaseClient("https://cdkxhfvlaartfvdsrjlz.supabase.co",
        "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6ImNka3hoZnZsYWFydGZ2ZHNyamx6Iiwicm9sZSI6ImFub24iLCJpYXQiOjE3NjA1NjIyNjMsImV4cCI6MjA3NjEzODI2M30.dsOQvtArgtLy981-We_RdAOEPGXIiY7xFbhjRNc7sZk") {
        install(Postgrest)
        install(Auth)
        install(Realtime)
        install(Storage)
    }
}