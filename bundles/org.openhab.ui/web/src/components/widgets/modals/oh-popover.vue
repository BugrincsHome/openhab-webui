<template>
  <f7-popover :target="el">
    <component :is="componentType" :context="context" :class="{notready: !ready}" />
  </f7-popover>
</template>

<style lang="stylus">
.notready
  visibility hidden
</style>

<script>
import OhLayoutPage from '@/components/widgets/layout/oh-layout-page.vue'

export default {
  components: {
    'oh-layout-page': OhLayoutPage,
    'oh-map-page': () => import('@/components/widgets/map/oh-map-page.vue'),
    'oh-plan-page': () => import('@/components/widgets/plan/oh-plan-page.vue'),
    'oh-chart-page': () => import('@/components/widgets/chart/oh-chart-page.vue')
  },
  props: ['uid', 'el', 'modalParams'],
  data () {
    return {
    }
  },
  computed: {
    context () {
      return {
        component: Object.assign({}, this.page || this.widget || this.standard, { config: this.modalParams }),
        store: this.$store.getters.trackedItems,
        props: this.modalParams
      }
    },
    page () {
      return (this.uid.indexOf('page:') === 0) ? this.$store.getters.page(this.uid.substring(5)) : null
    },
    widget () {
      return (this.uid.indexOf('widget:') === 0) ? this.$store.getters.widget(this.uid.substring(7)) : null
    },
    standard () {
      return (this.uid.indexOf('oh-') === 0) ? { component: this.uid } : null
    },
    ready () {
      return this.page || this.widget || this.standard
    },
    componentType () {
      if (this.page) {
        return this.page.component
      } else if (this.widget || this.standard) {
        return 'generic-widget-component'
      }
      return null
    }
  }
}
</script>
